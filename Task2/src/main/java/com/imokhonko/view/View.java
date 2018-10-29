package com.imokhonko.view;

import com.imokhonko.controller.ClientCredits;
import com.imokhonko.controller.MainMenu;
import com.imokhonko.model.Bank;
import com.imokhonko.model.Client;
import com.imokhonko.model.Loan;

import java.util.List;
import java.util.Scanner;

public class View {

    List<Client> clients = null;
    List<Bank> banks = null;

    public View(List<Client> clients, List<Bank> banks) {
        this.clients = clients;
        this.banks = banks;
    }

    public void printMainMenu(List<Client> clients, List<Bank> banks) {
        System.out.println("1. Choose credit");
        System.out.println("2. List of available credits");
        System.out.println("3. Your credits");

        Scanner scanner = new Scanner(System.in);

        int choose = scanner.nextInt();

        switch(choose) {
            case 1: {

            } break;
            case 2: {

            } break;
            case 3: {
//                ClientCredits clientCredits = new ClientCredits(clients.get(0));
//                clientCredits.setBanks(banks);
//                clientCredits.processRequest();
            } break;
            default: {
                System.out.println("erroreowroo");
            }
        }

    }

    public void printUserLoans(List<Loan> loans) {
        loans.forEach(System.out::println);

        System.out.println("1. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        int choose = scanner.nextInt();

        switch(choose) {
            case 1: {
                MainMenu mainMenu = new MainMenu(clients, banks);
            }
            break;

        }

    }

}
