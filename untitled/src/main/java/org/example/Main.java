package org.example;

import org.example.Animals.Animal;
import org.example.Animals.AnimalsHome.HomeAnimal;
import org.example.Animals.AnimalsHome.Program.AnimalRegistry;
import org.example.Animals.AnimalsHome.Program.Count;
import org.example.Animals.AnimalsPack.PackAnimal;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try (Count counter = new Count()) {
            AnimalRegistry animalRegistry = new AnimalRegistry();
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;
            while (!exit) {
                System.out.println("Выберите действие:");
                System.out.println("1. Добавить животное");
                System.out.println("2. Определить класс животного");
                System.out.println("3. Обучить новую команду упряжке");
                System.out.println("4. Показать список команд животного");
                System.out.println("0. Выйти");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Считываем символ новой строки после ввода числа

                switch (choice) {
                    case 1:
                        System.out.println("Введите имя животного: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите тип животного (home/pack): ");
                        String type = scanner.nextLine();

                        if ("home".equalsIgnoreCase(type)) {
                            animalRegistry.addAnimal(new HomeAnimal(name));
                        } else if ("pack".equalsIgnoreCase(type)) {
                            animalRegistry.addAnimal(new PackAnimal(name));
                        }
                        break;
                    case 2:
                        System.out.println("Введите имя животного для определения класса: ");
                        String animalName = scanner.nextLine();
                        for (Animal animal : animalRegistry.getAnimals()) {
                            if (animal.getName().equalsIgnoreCase(animalName)) {
                                animalRegistry.determineAnimalClass(animal);
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Введите имя упряжки для обучения новой команде: ");
                        String packAnimalName = scanner.nextLine();
                        System.out.println("Введите новую команду: ");
                        String newCommand = scanner.nextLine();
                        for (Animal animal : animalRegistry.getAnimals()) {
                            if (animal instanceof PackAnimal && animal.getName().equalsIgnoreCase(packAnimalName)) {
                                animalRegistry.teachNewCommand((PackAnimal) animal, newCommand);
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Список команд у животных:");
                        for (Animal animal : animalRegistry.getAnimals()) {
                            if (animal instanceof PackAnimal) {
                                PackAnimal packAnimal = (PackAnimal) animal;
                                System.out.println(packAnimal.getName() + ": " + packAnimal.getCommand());
                            }
                        }
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте снова.");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}