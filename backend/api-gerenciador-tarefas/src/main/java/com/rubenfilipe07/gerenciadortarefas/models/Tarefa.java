package com.rubenfilipe07.gerenciadortarefas.models;

import java.io.Serializable;
import java.time.LocalDate;

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

}

enum SituacaoTarefa {
	EM_ANDAMENTO(1), CONCLUIDA(2);

	private final int codigo;

	private SituacaoTarefa(int codigo) {
		this.codigo = codigo;
	}

	private int getCodigo() {
		return codigo;
	}

	public static SituacaoTarefa valueOf(int codigo) {
		for (SituacaoTarefa s : SituacaoTarefa.values()) {
			if (s.getCodigo() == codigo) {
				return s;
			}
		}
		throw new IllegalArgumentException("Código inválido");
	}

}

enum PrioridadeTarefa {
	ALTA, MEDIA, BAIXA,
}