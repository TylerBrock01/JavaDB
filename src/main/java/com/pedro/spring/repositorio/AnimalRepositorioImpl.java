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
        List<Animal> animals = new ArrayList<>();
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
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    animales = crearAnimal(rs);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animales;
    }

    @Override
    public void guardar(Animal animal) {
        String sql;
        if (animal.getId() >0) sql = "UPDATE santuario SET nombre=?, edad=?, genero=?, altura=?, tipo=? where idAnimal=?";
        else {
            sql = "INSERT INTO santuario(nombre, edad, genero, altura, tipo) VALUES (?,?,?,?,?)";
        }
        try(PreparedStatement stmt = getconection().prepareStatement(sql)){
            stmt.setString(1,animal.getAnimalName());
            stmt.setInt(2,animal.getAge());
            stmt.setString(3,animal.getGender());
            stmt.setString(4,animal.getHeight());
            stmt.setString(5, animal.getAnimalType());

            if (animal.getId()>0) {
                stmt.setLong(6,animal.getId());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = getconection().prepareStatement("DELETE FROM santuario WHERE id_animal=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
