package com.rubenfilipe07.gerenciadortarefas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubenfilipe07.gerenciadortarefas.dtos.AuthenticationDTO;
import com.rubenfilipe07.gerenciadortarefas.dtos.LoginResponseDTO;
import com.rubenfilipe07.gerenciadortarefas.dtos.RegisterDTO;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;
import com.rubenfilipe07.gerenciadortarefas.security.TokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("auth")
@Tag(name = "auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Loga um usuário com email e senha", method = "POST")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
   
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "Cadastra um novo usuário", method = "POST")
    @PostMapping("/cadastro")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.usuarioRepository.findByEmail(data.getEmail()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario newUsuario = new Usuario(data.getNome(), data.getEmail(), encryptedPassword, data.getRole());

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.ok().build();
    }
}
