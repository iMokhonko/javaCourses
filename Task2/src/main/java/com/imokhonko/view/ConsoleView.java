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

    // main menu items
    private String GET_ALL_VEHICLES_MENU_ITEM = rb.getString("getAllVehiclesMenuItems");
    private String FILTERED_VEHICLES_MENU_ITEM = rb.getString("filterVehiclesMenuItem");
    private String SETTINGS_MENU_ITEM = rb.getString("settingsMenuItem");

    // settings menu items
    private String CHANGE_LANGUAGE_MENU_ITEM = rb.getString("changeLanguage");

    // common user menu item choice phrase
    private String USER_MENU_CHOICE = rb.getString("userMenuChoice");

    // common phrases for nagivation
    private String BACK_TO_MAIN_MENU_MENU_ITEM = rb.getString("backToMainMenu");
    private String BACK_TO_SETTINGS_MENU_ITEM = rb.getString("backToSettingsMenu");
    private String BACK_TO_FILTER_MENU_ITEM = rb.getString("backToFilterMenu");

    // filter menu items
    private String FLYABLE_VEHICLES_MENU_ITEM = rb.getString("flyableVehicles");
    private String VEHICLES_WITH_SPEED_RANGE_FROM_200_TO_500 = rb.getString("vehiclesWithSpeedRangeFrom200To500");
    private String VEHICLES_WITH_ALTITUDE_HIGHER_THAN_5000 = rb.getString("vehiclesWithAltitudeHigherThan5000");
    private String VEHICLES_WITH_MIN_PRICE = rb.getString("vehiclesWithMinPrice");

    public void printMainMenu() {
        System.out.println("1. " + GET_ALL_VEHICLES_MENU_ITEM);
        System.out.println("2. " + FILTERED_VEHICLES_MENU_ITEM);
        System.out.println("3. " + SETTINGS_MENU_ITEM);

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
        System.out.println("1. " + CHANGE_LANGUAGE_MENU_ITEM);
        System.out.println("2. " + BACK_TO_MAIN_MENU_MENU_ITEM);

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

        System.out.println("4. " + BACK_TO_SETTINGS_MENU_ITEM);
        System.out.println("5. " + BACK_TO_MAIN_MENU_MENU_ITEM);

        Scanner scanner = new Scanner(System.in);
        printUserMenuChoose();
        int menuItem = scanner.nextInt();

        switch(menuItem) {
            case 1: {
                Controller changeLanguge = new ChangeLanguage(ChangeLanguage.Language.ENGLISH);
                changeLanguge.processRequest();
            } break;
            case 2: {
                Controller changeLanguge = new ChangeLanguage(ChangeLanguage.Language.RUSSIAN);
                changeLanguge.processRequest();
            } break;
            case 3: {
                Controller changeLanguge = new ChangeLanguage(ChangeLanguage.Language.UKRAINIAN);
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
        System.out.println("1. " + BACK_TO_MAIN_MENU_MENU_ITEM);
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
        System.out.println("1. " + BACK_TO_FILTER_MENU_ITEM);
        System.out.println("2. " + BACK_TO_MAIN_MENU_MENU_ITEM);
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
        System.out.println("1. " + VEHICLES_WITH_MIN_PRICE);
        System.out.println("2. " + VEHICLES_WITH_ALTITUDE_HIGHER_THAN_5000);
        System.out.println("3. " + VEHICLES_WITH_SPEED_RANGE_FROM_200_TO_500);
        System.out.println("4. " + FLYABLE_VEHICLES_MENU_ITEM);
        System.out.println("5. " + BACK_TO_MAIN_MENU_MENU_ITEM);

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
        makeSpace(1);
        System.out.print(USER_MENU_CHOICE + " -> ");
    }

}
