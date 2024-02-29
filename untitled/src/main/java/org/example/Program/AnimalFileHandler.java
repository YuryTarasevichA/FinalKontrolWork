package org.example.Program;

import org.example.Animals.Animal;
import org.example.Animals.AnimalsHome.HomeAnimal;
import org.example.Animals.AnimalsPack.PackAnimal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalFileHandler {
    public static void writeAnimalsToFile(List<Animal> animals) {
        String filename = "Animal.txt";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Animal animal : animals) {
                outputStream.writeObject(animal.getClass().getName()); // Записываем имя класса
                outputStream.writeObject(animal); // Записываем сам объект
            }
            System.out.println("Животные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public static List<Animal> readAnimalsFromFile() {
        List<Animal> animals = new ArrayList<>();
        String filename = "Animal.txt";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                String className = (String) inputStream.readObject(); // Читаем имя класса
                switch (className) {
                    case "org.example.Animals.AnimalsHome.HomeAnimal":
                        animals.add((HomeAnimal) inputStream.readObject());
                        break;
                    case "org.example.Animals.AnimalsPack.PackAnimal":
                        animals.add((PackAnimal) inputStream.readObject());
                        break;
                }
            }
        } catch (EOFException e) {
            System.out.println("Животные успешно загружены из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        }
        return animals;
    }
}
