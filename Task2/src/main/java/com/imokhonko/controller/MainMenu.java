package com.imokhonko.controller;

import com.imokhonko.model.Bank;
import com.imokhonko.model.Client;
import com.imokhonko.view.View;

import java.util.List;

public class MainMenu implements Controller {

    List<Client> clients = null;
    List<Bank> banks = null;
    View view = null;

    public MainMenu(List<Client> clients, List<Bank> banks) {
        this.clients = clients;
        this.banks = banks;
        view = new View(clients, banks);
    }

    @Override
    public void processRequest() {
        view.printMainMenu(clients, banks);
    }
}
