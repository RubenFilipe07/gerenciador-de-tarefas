package com.rubenfilipe07.gerenciadortarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByResponsavel(Usuario usuario);

}
