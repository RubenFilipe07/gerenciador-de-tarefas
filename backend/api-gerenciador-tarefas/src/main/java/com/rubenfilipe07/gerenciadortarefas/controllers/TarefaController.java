package com.rubenfilipe07.gerenciadortarefas.controllers;

import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.services.TarefaService; 
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

    @PostMapping
    public ResponseEntity<Tarefa> saveTarefa(@RequestBody Tarefa tarefaModel) {
        return tarefaService.saveTarefa(tarefaModel);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTarefa(@PathVariable long id, @RequestBody Tarefa tarefaModel) {
        return tarefaService.updateTarefa(id, tarefaModel);  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOneTarefa(@PathVariable long id) {
        return tarefaService.deleteOneTarefa(id); 
    }
}
