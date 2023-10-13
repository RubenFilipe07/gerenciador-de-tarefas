package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.repositories.TarefaRepository;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TarefaController {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/tarefas/{id}")
	public ResponseEntity<Object> getOneTarefa(@PathVariable long id) {

		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		}

		else {
			return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findById(id));
		}
	}

	@GetMapping("/tarefas")
	public ResponseEntity<Object> getAllTarefasByUsuario(@RequestParam(name = "usuario", required = false) Long id) {
	    if (id != null) {
	        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

	        if (usuarioOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
	        }

	        List<Tarefa> tarefasDoUsuario = tarefaRepository.findByResponsavel(usuarioOptional.get());
	        return ResponseEntity.status(HttpStatus.OK).body(tarefasDoUsuario);
	    } else {
	        List<Tarefa> todasAsTarefas = tarefaRepository.findAll();
	        return ResponseEntity.status(HttpStatus.OK).body(todasAsTarefas);
	    }
	}

	@PostMapping("/tarefas")
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));

	}

	@PutMapping("/tarefas/{id}")
	public ResponseEntity<Object> updateTarefa(@PathVariable long id, @RequestBody Tarefa tarefaModel) {

		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));

		}

	}

	@DeleteMapping("/tarefas/{id}")
	public ResponseEntity<Object> deleteOneTarefa(@PathVariable long id) {

		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		} else {
			tarefaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada com sucesso");

		}

	}

}
