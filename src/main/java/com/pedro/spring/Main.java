package com.pedro.spring;

import com.pedro.spring.models.Animal;
import com.pedro.spring.repositorio.AnimalRepositorioImpl;
import com.pedro.spring.repositorio.Repositorio;
import com.pedro.spring.util.ConexionBaseDatos;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conn= ConexionBaseDatos.getinstance();){
            Repositorio<Animal> repositorio = new AnimalRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

//            no jala
            System.out.println(repositorio.porid(1L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}