package com.imokhonko.controller;

import com.imokhonko.model.Bank;
import com.imokhonko.model.Client;
import com.imokhonko.view.View;

import java.util.ArrayList;
import java.util.List;

public class ClientCredits implements Controller {

    View view = null;
    Client client = null;
    List<Bank> banks = null;

    public ClientCredits(List<Client> clients, List<Bank> banks) {
        //this.client = clients;
    }


    public void setBanks(List<Bank> banks) {
        for(Bank bank : banks) {
            this.banks.add(bank);
        }
    }

    @Override
    public void processRequest() {
        view.printUserLoans(client.getMyLoans(this.banks));
    }
}
