package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.services.TarefaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTarefa(@PathVariable long id) {
		return tarefaService.getOneTarefa(id);
	}

	@GetMapping
	public ResponseEntity<Object> getAllTarefasByUsuario(@RequestParam(name = "usuario", required = false) Long id) {
		return tarefaService.getAllTarefasByUsuario(id);
	}

	  @GetMapping("/filtro")
	    public ResponseEntity<Object> getAllTarefasByFiltro(
	            @RequestParam(name = "id", required = false) Long id,
	            @RequestParam(name = "titulo", required = false) String titulo,
	            @RequestParam(name = "descricao", required = false) String descricao,
	            @RequestParam(name = "responsavel", required = false) Usuario responsavel,
	            @RequestParam(name = "situacao", required = false) SituacaoTarefa situacao) {
	        List<Tarefa> tarefas = tarefaService.getAllTarefasByFiltro(id, titulo, descricao, responsavel, situacao);
	        return ResponseEntity.ok(tarefas);
	    }
	  
	@PostMapping
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefaModel) {
		return tarefaService.saveTarefa(tarefaModel);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTarefa(@PathVariable long id, @RequestBody Tarefa tarefaModel) {
		return tarefaService.updateTarefa(id, tarefaModel);
	}

	@PutMapping("/{id}/concluida")
	public ResponseEntity<Object> updateTarefaConcluida(@PathVariable long id) {
		return tarefaService.updateTarefaConcluida(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneTarefa(@PathVariable long id) {
		return tarefaService.deleteOneTarefa(id);
	}
}
