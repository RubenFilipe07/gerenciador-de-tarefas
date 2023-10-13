package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneUsuario(@PathVariable long id) {
		return usuarioService.getOneUsuario(id);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(id, usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneUsuario(@PathVariable long id) {
		return usuarioService.deleteOneUsuario(id);
	}
}
