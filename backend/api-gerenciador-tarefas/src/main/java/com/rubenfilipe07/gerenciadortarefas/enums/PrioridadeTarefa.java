package com.rubenfilipe07.gerenciadortarefas.enums;

public enum PrioridadeTarefa {
    ALTA(1), MEDIA(2), BAIXA(3);

    private final int codigo;

    private PrioridadeTarefa(int codigo) {
        this.codigo = codigo;
    }

    private int getCodigo() {
        return codigo;
    }

    public static PrioridadeTarefa valueOf(int codigo) {
        for (PrioridadeTarefa p : PrioridadeTarefa.values()) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
