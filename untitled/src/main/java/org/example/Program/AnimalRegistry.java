package org.example.Program;

import org.example.Animals.Animal;
import org.example.Animals.AnimalsHome.HomeAnimal;
import org.example.Animals.AnimalsPack.PackAnimal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry{
    private List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void determineAnimalClass(Animal animal) {
        if (animal instanceof HomeAnimal) {
            System.out.println("This animal is a home animal.");
        } else if (animal instanceof PackAnimal) {
            System.out.println("This animal is a pack animal.");
        } else {
            System.out.println("Unknown type of animal.");
        }
    }
    public void teachNewCommand(PackAnimal packAnimal, String newCommand) {
        packAnimal.setCommand(newCommand);
        System.out.println("New command taught: " + newCommand);
    }
}
