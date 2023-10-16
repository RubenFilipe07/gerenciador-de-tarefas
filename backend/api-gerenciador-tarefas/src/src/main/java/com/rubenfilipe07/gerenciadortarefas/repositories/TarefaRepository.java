package com.rubenfilipe07.gerenciadortarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Tarefa;
import com.rubenfilipe07.gerenciadortarefas.models.Usuario;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByResponsavel(Usuario usuario);

	@Query("SELECT t FROM Tarefa t " +
		       "WHERE (:id IS NULL OR t.id = :id) " +
		       "AND (:titulo IS NULL OR t.titulo = :titulo) " +
		       "AND (:descricao IS NULL OR t.descricao = :descricao) " +
		       "AND (:situacao IS NULL OR t.situacao = :situacao)" +
		       "AND (:responsavel IS NULL OR t.responsavel = :responsavel)"
		       
			)
		List<Tarefa> getAllTarefasByFiltro(
		    @Param("id") Long id,
		    @Param("titulo") String titulo,
		    @Param("descricao") String descricao,
		    @Param("responsavel") Usuario responsavel,
		    @Param("situacao") SituacaoTarefa situacao
		);

}
