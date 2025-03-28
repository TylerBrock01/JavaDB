package com.pedro.spring;

import com.pedro.spring.models.Animal;
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
            animal.setId(1);
            animal.setAnimalName("puma");
            animal.setAge(1);
            animal.setGender("Male");
            animal.setHeight("mediano");
            animal.setAnimalType("terrestre");
            repositorio.guardar(animal);
            System.out.println("animal guardado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}