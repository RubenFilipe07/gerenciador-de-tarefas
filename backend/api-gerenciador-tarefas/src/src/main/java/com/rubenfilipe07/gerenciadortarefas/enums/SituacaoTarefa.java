package com.rubenfilipe07.gerenciadortarefas.enums;

public enum SituacaoTarefa {
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
