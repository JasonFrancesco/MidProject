package com.tutorial;

import java.util.*;

abstract class Vehicle {
    protected String type;
    protected String brand;
    protected String name;
    protected String licenseNumber;
    protected int topSpeed;
    protected int gasCap;
    protected int wheel;

    public Vehicle(String type, String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.topSpeed = topSpeed;
        this.gasCap = gasCap;
        this.wheel = wheel;
    }

    public abstract void specialInfo(Scanner scanner);
}

class Car extends Vehicle {
    private String carType;
    private int entertainmentSystem;

    public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String carType, int entertainmentSystem) {
        super("Car", brand, name, licenseNumber, topSpeed, gasCap, wheel);
        this.carType = carType;
        this.entertainmentSystem = entertainmentSystem;
    }

    @Override
    public void specialInfo(Scanner scanner) {
        System.out.print("Enter car type (SUV/Supercar/Minivan): ");
        carType = scanner.nextLine();
        System.out.print("Enter number of entertainment systems: ");
        entertainmentSystem = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", topSpeed=" + topSpeed +
                ", gasCap=" + gasCap +
                ", wheel=" + wheel +
                ", carType='" + carType + '\'' +
                ", entertainmentSystem=" + entertainmentSystem +
                '}';
    }
}

class Motorcycle extends Vehicle {
    private String bikeType;
    private int helmets;

    public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String bikeType, int helmets) {
        super("Motorcycle", brand, name, licenseNumber, topSpeed, gasCap, wheel);
        this.bikeType = bikeType;
        this.helmets = helmets;
    }

    @Override
    public void specialInfo(Scanner scanner) {
        System.out.print("Enter bike type (Automatic/Manual): ");
        bikeType = scanner.nextLine();
        System.out.print("Enter number of helmets: ");
        helmets = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", topSpeed=" + topSpeed +
                ", gasCap=" + gasCap +
                ", wheel=" + wheel +
                ", bikeType='" + bikeType + '\'' +
                ", helmets=" + helmets +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Input");
            System.out.println("2. View");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    inputVehicle(scanner, vehicles);
                    break;
                case 2:
                    viewVehicles(vehicles);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void inputVehicle(Scanner scanner, List<Vehicle> vehicles) {
        System.out.print("\nEnter vehicle type (Car/Motorcycle): ");
        String type = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter license number: ");
        String licenseNumber = scanner.nextLine();
        System.out.print("Enter top speed: ");
        int topSpeed = scanner.nextInt();
        System.out.print("Enter gas capacity: ");
        int gasCap = scanner.nextInt();
        System.out.print("Enter number of wheels: ");
        int wheel = scanner.nextInt();

        if (type.equalsIgnoreCase("Car")) {
            System.out.print("Enter car type (SUV/Supercar/Minivan): ");
            String carType = scanner.nextLine();
            System.out.print("Enter number of entertainment systems: ");
            int entertainmentSystem = scanner.nextInt();
            vehicles.add(new Car(brand, name, licenseNumber, topSpeed, gasCap, wheel, carType, entertainmentSystem));
        } else if (type.equalsIgnoreCase("Motorcycle")) {
            System.out.print("Enter bike type (Automatic/Manual): ");
            String bikeType = scanner.nextLine();
            System.out.print("Enter number of helmets: ");
            int helmets = scanner.nextInt();
            vehicles.add(new Motorcycle(brand, name, licenseNumber, topSpeed, gasCap, wheel, bikeType, helmets));
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public static void viewVehicles(List<Vehicle> vehicles) {
        System.out.println("\nList of Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}

