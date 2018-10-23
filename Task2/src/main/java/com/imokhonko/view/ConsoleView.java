package com.imokhonko.view;

import com.imokhonko.controller.VehiclesController;
import com.imokhonko.model.Vehicle;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleView {

    private static Locale locale = new Locale("en", "US");
    private static ResourceBundle rb = ResourceBundle.getBundle("language", locale);

    public static void printMainMenu() {
        System.out.println("1. " + rb.getString("getAllVehiclesMenuItems"));
        System.out.println("2. " + rb.getString("filterVehiclesMenuItem"));
        System.out.println("3. " + rb.getString("settingsMenuItem"));

        Scanner scanner = new Scanner(System.in);

        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                makeSpace(1);
                printVehicles(VehiclesController.getAllVehicles());
            } break;
            case 2: {
                makeSpace(1);
                printSortingMenu();
            } break;
            case 3: {
                makeSpace(1);
                printSettingsMenu();
            } break;
        }

    }

    public static void printSettingsMenu() {
        System.out.println("1. Change language");
        System.out.println("2. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                makeSpace(1);
                printLanguageMenu();
            } break;
            case 2: {
                makeSpace(1);
                printMainMenu();
            } break;
        }
    }

    private static void printLanguageMenu() {
        System.out.println("1. English");
        System.out.println("2. Russian");
        System.out.println("3. Ukrainian");

        System.out.println("4. Back to settings menu");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {

            } break;
            case 2: {

            } break;
            case 3: {

            } break;
            case 4: {
                makeSpace(1);
                printSettingsMenu();
            } break;
            case 5: {
                makeSpace(1);
                printMainMenu();
            } break;
        }
    }

    public static void printVehicles(List<Vehicle> vehicles) {
        vehicles.forEach(System.out::println);
    }

    public static void printSortingMenu() {
        System.out.println("1. Vehicles with min price");
        System.out.println("2. Vehicles with altitude higher than 5000");
        System.out.println("3. Vehicles with speed range from 200 to 500");
        System.out.println("4. Flyable vehicles");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {

            } break;
            case 2: {

            } break;
            case 3: {

            } break;
            case 4: {
                makeSpace(1);

            } break;
            case 5: {
                makeSpace(1);
                printMainMenu();
            } break;
        }
    }

    private static void makeSpace(int lines) {
        for(int i = 0; i < lines; i++)
            System.out.println();
    }

    private static void printUserMenuChoose() {
        System.out.print("Enter the menu number -> ");
    }

}
