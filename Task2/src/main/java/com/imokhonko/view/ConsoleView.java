package com.imokhonko.view;

import com.imokhonko.controller.*;
import com.imokhonko.model.Vehicle;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleView {

    private Locale locale = new Locale("en", "US");
    private ResourceBundle rb = ResourceBundle.getBundle("language", locale);

    public void printMainMenu() {
        System.out.println("1. " + rb.getString("getAllVehiclesMenuItems"));
        System.out.println("2. " + rb.getString("filterVehiclesMenuItem"));
        System.out.println("3. " + rb.getString("settingsMenuItem"));

        Scanner scanner = new Scanner(System.in);

        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                Controller settingsController = new AllVehiclesList();
                settingsController.processRequest();
                makeSpace(1);
            } break;
            case 2: {
                makeSpace(1);
                Controller filterMenu = new FilterMenu();
                filterMenu.processRequest();
            } break;
            case 3: {
                makeSpace(1);
                Controller settingsController = new SettingsMenu();
                settingsController.processRequest();
            } break;
        }

    }

    public void printSettingsMenu() {
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

    private void printLanguageMenu() {
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
                Controller settingsController = new SettingsMenu();
                settingsController.processRequest();
            } break;
            case 5: {
                makeSpace(1);
                Controller mainMenu = new MainMenu();
                mainMenu.processRequest();
            } break;
        }
    }

    public <T> void printVehicles(List<T> vehicles) {
        vehicles.forEach(System.out::println);

        makeSpace(1);
        System.out.println("1. Back to main menu");
        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                makeSpace(1);
                Controller mainMenu = new MainMenu();
                mainMenu.processRequest();
            }
            break;
        }
    }

    public <T> void printFilteredVehicles(List<T> vehicles) {
        vehicles.forEach(System.out::println);

        makeSpace(1);
        System.out.println("1. Back filter menu");
        System.out.println("2. Back to main menu");
        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                makeSpace(1);
                Controller filterMenu = new FilterMenu();
                filterMenu.processRequest();
            }
            case 2: {
                makeSpace(1);
                Controller mainMenu = new MainMenu();
                mainMenu.processRequest();
            }
            break;
        }
    }

    public void printSortingMenu() {
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
                makeSpace(1);
                Controller filteredVehicles = new FilteredVehicles("minPriceVehicls");
                filteredVehicles.processRequest();
            } break;
            case 2: {
                makeSpace(1);
                Controller filteredVehicles = new FilteredVehicles("higherAltitudeVehicles");
                filteredVehicles.processRequest();
            } break;
            case 3: {
                makeSpace(1);
                Controller filteredVehicles = new FilteredVehicles("speedRangeVehicles");
                filteredVehicles.processRequest();
            } break;
            case 4: {
                makeSpace(1);
                Controller filteredVehicles = new FilteredVehicles("flyableVehicles");
                filteredVehicles.processRequest();
            } break;
            case 5: {
                makeSpace(1);
                Controller mainMenu = new MainMenu();
                mainMenu.processRequest();
            } break;
        }
    }

    private void makeSpace(int lines) {
        for(int i = 0; i < lines; i++)
            System.out.println();
    }

    private void printUserMenuChoose() {
        System.out.print("Enter the menu number -> ");
    }

}
