package com.rubenfilipe07.gerenciadortarefas.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.repositories.TarefaRepository;


@RestController
@RequestMapping(value = "/api")
public class TarefaController {

	@Autowired
	TarefaRepository tarefaRepository;

	@GetMapping("/tarefa/{id}")
	public ResponseEntity<Object> getOneTarefa(@PathVariable long id) {
	
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		}

		else {
			return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findById(id));
		}
	}

	@GetMapping("/tarefas")
	public ResponseEntity<List<Tarefa>> getAllTarefas() {
		return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());
	}

	@PostMapping("/tarefas")
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefaModel) {
		
		BeanUtils.copyProperties(tarefaModel, tarefaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));

	}
	
	@PutMapping("/tarefa/{id}")
	public ResponseEntity<Object> updateTarefa(@PathVariable long id, 
										@RequestBody Tarefa tarefaModel ) {
		
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		}
		else {
			
			BeanUtils.copyProperties(tarefaModel, tarefaModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
			
		}
	
	}
	
	@DeleteMapping("/tarefa/{id}")
	public ResponseEntity<Object> deleteOneTarefa(@PathVariable long id) {
		
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
		}
		else {
			tarefaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada com sucesso");
			
		}
	
	}
	
	

}
