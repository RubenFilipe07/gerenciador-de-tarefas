package com.rubenfilipe07.gerenciadortarefas.models;
import com.rubenfilipe07.gerenciadortarefas.enums.PrioridadeTarefa;
import com.rubenfilipe07.gerenciadortarefas.enums.SituacaoTarefa;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TAREFAS")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	@Column(columnDefinition = "TEXT")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Usuario responsavel;

	private PrioridadeTarefa prioridade;
	private LocalDate deadline;
	private SituacaoTarefa situacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PrioridadeTarefa getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeTarefa prioridade) {
		this.prioridade = prioridade;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public SituacaoTarefa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoTarefa situacao) {
		this.situacao = situacao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deadline, descricao, id, prioridade, responsavel, situacao, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(descricao, other.descricao) && id == other.id
				&& prioridade == other.prioridade && Objects.equals(responsavel, other.responsavel)
				&& situacao == other.situacao && Objects.equals(titulo, other.titulo);
	}

}