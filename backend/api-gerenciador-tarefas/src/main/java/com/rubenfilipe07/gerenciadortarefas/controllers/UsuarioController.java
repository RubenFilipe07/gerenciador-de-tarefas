package com.rubenfilipe07.gerenciadortarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Object> getOneUsuario(@PathVariable long id) {

		if (usuarioRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		}

		else {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
		}
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable long id, @RequestBody Usuario usuario) {

		if (usuarioRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));

		}

	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Object> deleteOneUsuario(@PathVariable long id) {

		if (usuarioRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		} else {
			usuarioRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso");

		}

	}

}
