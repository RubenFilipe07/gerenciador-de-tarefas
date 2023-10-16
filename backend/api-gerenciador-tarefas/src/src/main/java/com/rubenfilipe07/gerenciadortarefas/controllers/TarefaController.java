package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.services.TarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tarefas", produces = {"application/json"})
@Tag(name = "tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@Operation(summary = "Obtém uma tarefa por ID", method = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTarefa(@PathVariable long id) {
		return tarefaService.getOneTarefa(id);
	}


	@Operation(summary = "Obtém as tarefas com um filtro de usuário", method = "GET")
	@GetMapping
	public ResponseEntity<Object> getAllTarefasByUsuario(@RequestParam(name = "usuario", required = false) Long id) {
		return tarefaService.getAllTarefasByUsuario(id);
	}


	@Operation(summary = "Obtém tarefas com base em critérios de filtro", method = "GET")
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
	  
	@Operation(summary = "Cria uma nova tarefa", method = "POST")
	@PostMapping
	public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefaModel) {
		return tarefaService.saveTarefa(tarefaModel);
	}

	@Operation(summary = "Atualiza uma tarefa existente com base no ID", method = "PUT")
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTarefa(@PathVariable long id, @RequestBody Tarefa tarefaModel) {
		return tarefaService.updateTarefa(id, tarefaModel);
	}

	@Operation(summary = "Marca uma tarefa como concluída com base no ID", method = "PUT")
	@PutMapping("/{id}/concluida")
	public ResponseEntity<Object> updateTarefaConcluida(@PathVariable long id) {
		return tarefaService.updateTarefaConcluida(id);
	}

	@Operation(summary = "Exclui uma tarefa por ID", method = "DELETE")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOneTarefa(@PathVariable long id) {
		return tarefaService.deleteOneTarefa(id);
	}
}
