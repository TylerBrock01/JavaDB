package com.pedro.spring.repositorio;

import com.pedro.spring.models.Animal;
import com.pedro.spring.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepositorioImpl implements Repositorio<Animal> {
    private Connection getconection() {
        try {
            return ConexionBaseDatos.getinstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Animal> listar() {
        List<Animal> animals = new ArrayList<Animal>();
        try(Statement stmt = getconection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM santuario")){

            while (rs.next()) {
                Animal a = crearAnimal(rs);
                animals.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animals;
    }


    @Override
    public Animal porid(Long id) {
        Animal animales = null;
        try (PreparedStatement stmt = getconection().
                prepareStatement("SELECT * FROM santuario WHERE idAnimal =?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                animales = crearAnimal(rs);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animales;
    }

    @Override
    public void guardar(Animal animal) {

    }

    @Override
    public void eliminar(Long id) {

    }
    private static Animal crearAnimal(ResultSet rs) throws SQLException {
        Animal a = new Animal();
        a.setId(rs.getInt("idAnimal"));
        a.setAnimalName(rs.getString("nombre"));
        a.setAge(rs.getInt("edad"));
        a.setGender(rs.getString("genero"));
        a.setHeight(rs.getString("altura"));
        a.setAnimalType(rs.getString("tipo"));
        return a;
    }
}
