package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Computer {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;

    public Computer() {
    }

    public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
        this.ram = ram;
        this.cores = cores;
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.number = UUID.randomUUID();
    }

    static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    public int findText(String text, String search) {
        if (text == null || text.equals("") || search == null || search.equals(""))
            return -1;
        if (text.contains(search)) {
            System.out.println("Text contains search string");
            return text.indexOf(search);
        } else {
            System.err.println("Text does not contains search string");
        }
        return -1;
    }

    public static void playTheGame() {
        System.out.println("Try guess number from 1 to 100. You have only 5 attempts!");
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int attempts = 5;
        int number;
        int randomNumber = (int) (Math.random() * (100 - 1) + 1);
        for (int i = 0; i < attempts; i++) {
            System.out.println("Guess the number:");
            try {
                number = sc.nextInt();
                counter++;
                if (number == randomNumber) {
                    System.out.println("Yeah man! You did it! :-)");
                    break;
                } else if (number < randomNumber) {
                    System.out.println("The number is greater then " + number);
                } else if ((number > randomNumber)) {
                    System.out.println("The number is less then " + number);
                }

                if (attempts == counter) {
                    System.out.println("You lose. Game over!");
                    System.out.println("The number was " + randomNumber);
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong number format!");
                break;
            }
        }
        sc.close();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", cores=" + cores +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    enum OperatingSystem {
        Windows,
        Linux,
        MacOS
    }

    public static class ComputerBuilder {
        private int ram;
        private int cores;
        private String name;
        private UUID number;
        private OperatingSystem operatingSystem;

        public ComputerBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder cores(int cores) {
            this.cores = cores;
            return this;
        }

        public ComputerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder number() {
            this.number = UUID.randomUUID();
            return this;
        }

        public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
            //this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cores, name, operatingSystem);
        }
    }

}
