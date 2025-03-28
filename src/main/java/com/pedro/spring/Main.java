package com.pedro.spring;

import com.pedro.spring.models.Animal;
import com.pedro.spring.models.Residencia;
import com.pedro.spring.repositorio.AnimalRepositorioImpl;
import com.pedro.spring.repositorio.Repositorio;
import com.pedro.spring.util.ConexionBaseDatos;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection ignored = ConexionBaseDatos.getinstance()){
            Repositorio<Animal> repositorio = new AnimalRepositorioImpl();

            System.out.println("========== listar animals ==========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("========== Ver por id animals ==========");
            System.out.println(repositorio.porid(1L));

            System.out.println("========== Insertar animals ==========");
            Animal animal = new Animal();
            animal.setId(1L);
            animal.setAnimalName("coyote");
            animal.setAge(1);
            animal.setGender("macho");
            animal.setHeight("mediano");
            animal.setAnimalType("terrestre");
            Residencia residencia = new Residencia();
            residencia.setId(1L);
            animal.setResidencia(residencia);
            repositorio.guardar(animal);
            System.out.println("animal guardado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}