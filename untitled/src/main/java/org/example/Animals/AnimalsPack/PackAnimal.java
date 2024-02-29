package org.example.Animals.AnimalsPack;

import org.example.Animals.Animal;

public class PackAnimal extends Animal {

    private String appointment;
    private String command;

    public PackAnimal(String name, int id, String birthDate, String appointment, String command) {
        super(name, id, birthDate);
        this.appointment = appointment;
        this.command = command;
    }

    public PackAnimal(String name) {
        super(name);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
