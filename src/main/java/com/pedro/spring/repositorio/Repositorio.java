package com.pedro.spring.repositorio;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();

    T porid(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
