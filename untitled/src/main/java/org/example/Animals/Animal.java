package org.example.Animals;

public abstract class Animal {
    private String name;
    private int id;
    private String birthDate;

    public Animal(String name, int id, String birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public Animal(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
