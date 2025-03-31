package com.pedro.spring;

import com.pedro.spring.models.Animal;
import com.pedro.spring.repositorio.AnimalRepositorioImpl;
import com.pedro.spring.repositorio.Repositorio;

public class MainJdcUpdate {
    public static void main(String[] args) {

        Repositorio<Animal> repositorio = new AnimalRepositorioImpl();

        System.out.println("========== listar animals ==========");
        repositorio.listar().forEach(System.out::println);
        System.out.println("========== Actualizar animals ==========");
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setAnimalName("puma");
        animal.setAge(1);
        animal.setGender("Male");
        animal.setHeight("mediano");
        animal.setAnimalType("terrestre");
//        repositorio.guardar(animal);

        System.out.println("animal Actualizado con exito");
        repositorio.listar().forEach(System.out::println);
    }
}