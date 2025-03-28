package com.pedro.spring;

import com.pedro.spring.models.Animal;
import com.pedro.spring.repositorio.AnimalRepositorioImpl;
import com.pedro.spring.repositorio.Repositorio;
import com.pedro.spring.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class MainJdcDelete {
    public static void main(String[] args) {

        try (Connection ignored = ConexionBaseDatos.getinstance()){
            Repositorio<Animal> repositorio = new AnimalRepositorioImpl();

            System.out.println("========== listar animals ==========");
            repositorio.listar().forEach(System.out::println);
            System.out.println("========== Eliminar animals ==========");
            Animal animal = new Animal();
            animal.setId(3L);
            repositorio.eliminar(animal.getId());
            
            System.out.println("animal Eliminado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}