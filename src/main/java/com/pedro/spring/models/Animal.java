package com.pedro.spring.models;

public class Animal{
    private long id;
    private String animalName;
    private int age;
    private String gender;
    private String height;
    private String animalType;
    private Residencia residencia;
    public Animal() {
    }

    public Animal(long id, String animalName, int age, String gender, String height, String animalType) {
        this.id = id;
        this.animalName = animalName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.animalType = animalType;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return id+" "+
                animalName+" "+
                age+" "+
                gender+" "+
                height+" "+
                animalType+" "+
                residencia.getHabitacion();
    }

}
