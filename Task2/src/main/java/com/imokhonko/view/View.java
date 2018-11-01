package com.imokhonko.view;

import com.imokhonko.controller.AllCredits;
import com.imokhonko.model.Credit;
import com.imokhonko.controller.FindCredit;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void printMainMenu() {
        System.out.println("1. Best credits for you");
        System.out.println("2. Find credit");

        System.out.printf("Choose -> ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch(choose) {
            case 1: {
                new AllCredits().processRequest();
                break;
            }
            case 2: {
                printFindCreditMenu();
                break;
            }
            default: {
                System.out.println("________________________________");
                System.out.println("there is no such menu item");
                System.out.println("________________________________");
                printMainMenu();
            }
        }

    }

    private static void printFindCreditMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sum you want to get ->");
        double sum = scanner.nextDouble();

        System.out.println("Enter the months ->");
        int months = scanner.nextInt();

        System.out.println("Enter the percents ->");
        double percents = scanner.nextDouble();

        new FindCredit(sum, months, percents).processRequest();

        System.out.println("1. Back to main menu");
        System.out.println("Choose ->");
        int choose = scanner.nextInt();

        switch(choose) {
            case 1: {
                printMainMenu();
            } default: {
                System.out.printf("To back to main menu please enter 1");
                new FindCredit(sum, months, percents).processRequest();
            }
        }

    }

    public static void printCredits(List<Credit> credits) {

        if(credits.size() > 0) {
            credits.forEach(System.out::println);
        } else {
            System.out.println("No available credits found!");
        }

        System.out.println("1. Back to main menu");

        System.out.printf("Choose -> ");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch(choose) {
            case 1: {
                printMainMenu();
                break;
            }
            default: {
                System.out.println("________________________________");
                System.out.println("input 1 to back to main menu");
                System.out.println("________________________________");
                printCredits(credits);
            }
        }
    }

}
