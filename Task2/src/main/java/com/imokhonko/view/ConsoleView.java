package com.imokhonko.view;

import com.imokhonko.controller.*;
import com.imokhonko.model.helpers.UTF8Control;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleView {

    private Locale locale = Locale.getDefault();
    private ResourceBundle rb = ResourceBundle.getBundle("language", locale, new UTF8Control());

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
        System.out.println("1. " + rb.getString("changeLanguage"));
        System.out.println("2. " + rb.getString("backToMainMenu"));

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
        System.out.println("2. Русский");
        System.out.println("3. Українська");

        System.out.println("4. " + rb.getString("backToSettingsMenu"));
        System.out.println("5. " + rb.getString("backToMainMenu"));

        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                Controller changeLanguge = new ChangeLanguageController(ChangeLanguageController.Language.ENGLISH);
                changeLanguge.processRequest();
            } break;
            case 2: {
                Controller changeLanguge = new ChangeLanguageController(ChangeLanguageController.Language.RUSSIAN);
                changeLanguge.processRequest();
            } break;
            case 3: {
                Controller changeLanguge = new ChangeLanguageController(ChangeLanguageController.Language.UKRAINIAN);
                changeLanguge.processRequest();
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
        System.out.println("1. " + rb.getString("backToMainMenu"));
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
        System.out.println("1. " + rb.getString("backToFilterMenu"));
        System.out.println("2. " + rb.getString("backToMainMenu"));
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
        System.out.println("1. " + rb.getString("vehiclesWithMinPrice"));
        System.out.println("2. " + rb.getString("vehiclesWithAltitudeHigherThan5000"));
        System.out.println("3. " + rb.getString("vehiclesWithSpeedRangeFrom200To500"));
        System.out.println("4. " + rb.getString("flyableVehicles"));
        System.out.println("5. " + rb.getString("backToMainMenu"));

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
        System.out.print(rb.getString("userMenuChoice") + " -> ");
    }

}
