package com.rubenfilipe07.gerenciadortarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;
import com.rubenfilipe07.gerenciadortarefas.repositories.TarefaRepository;
import com.rubenfilipe07.gerenciadortarefas.repositories.UsuarioRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public ResponseEntity<Object> getOneTarefa(long id) {
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Tarefa não encontrada\"}");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findById(id));
		}
	}

	public ResponseEntity<Object> getAllTarefasByUsuario(Long id) {
		if (id != null) {
			Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

			if (usuarioOptional.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Usuario nao encontrado\"}");
			}

			List<Tarefa> tarefasDoUsuario = tarefaRepository.findByResponsavel(usuarioOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body(tarefasDoUsuario);
		} else {
			List<Tarefa> todasAsTarefas = tarefaRepository.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(todasAsTarefas);
		}
	}

	public ResponseEntity<Tarefa> saveTarefa(Tarefa tarefaModel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
	}

	public ResponseEntity<Object> updateTarefa(long id, Tarefa tarefaModel) {
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Tarefa não encontrada\"}");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));
		}
	}
	
	public ResponseEntity<Object> updateTarefaConcluida(long id) {
	    Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

	    if (tarefaOptional.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Tarefa não encontrada\"}");
	    } else {
	        Tarefa tarefa = tarefaOptional.get();
	        tarefa.setSituacao(SituacaoTarefa.CONCLUIDA);
	        tarefaRepository.save(tarefa);
	        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\":\"Tarefa marcada como concluida\"}");
	    }
	}

	public ResponseEntity<Object> deleteOneTarefa(long id) {
		if (tarefaRepository.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\":\"Tarefa não encontrada\"}");
		} else {
			tarefaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"Tarefa deletada com sucesso\"}");
		}
	}
}
