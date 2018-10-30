package com.imokhonko.view;

import com.imokhonko.controller.AllCredits;
import com.imokhonko.Credit;
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
                AllCredits allCredits = new AllCredits();
                allCredits.processRequest();
                break;
            }
            case 2: {
                FindCredit findCredit = new FindCredit();
                findCredit.processRequest();
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

    public static void printAllCredits(List<Credit> credits) {
        credits.forEach(System.out::println);

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
                printAllCredits(credits);
            }
        }
    }

}
