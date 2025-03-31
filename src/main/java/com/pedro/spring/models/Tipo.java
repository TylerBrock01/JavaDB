package com.pedro.spring.models;

public enum Tipo {
    TERRESTRE("terrestre"),
    ACUATICO("acuatico"),
    AEREO("aereo");

    private final String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
