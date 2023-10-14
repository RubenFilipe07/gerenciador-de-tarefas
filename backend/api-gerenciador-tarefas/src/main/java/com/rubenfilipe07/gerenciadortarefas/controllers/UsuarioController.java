package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/usuarios", produces = {"application/json"})
@Tag(name = "usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@Operation(summary = "Obtém um usuário por ID", method = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneUsuario(@PathVariable long id) {
		return usuarioService.getOneUsuario(id);
	}

	@Operation(summary = "Obtém todos os usuários", method = "GET")
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@Operation(summary = "Salva um novo usuário", method = "POST")
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@Operation(summary = "Atualiza um usuário existente", method = "PUT")
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(id, usuario);
	}

	@Operation(summary = "Deleta um usuário por ID", method = "DELETE")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneUsuario(@PathVariable long id) {
		return usuarioService.deleteOneUsuario(id);
	}
}
