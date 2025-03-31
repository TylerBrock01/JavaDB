package com.pedro.spring.models;

public enum Height {
    PEQUENIO("pequenio"),
    MEDIANO("mediano"),
    GRANDE("grande");

    private final String estado;

    Height(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado;
    }
}
