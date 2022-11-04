package org.example;

import java.sql.SQLOutput;
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

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
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

    public enum OperatingSystem {
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
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cores, name, operatingSystem);
        }
    }

}
