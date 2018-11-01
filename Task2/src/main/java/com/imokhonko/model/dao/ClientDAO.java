package com.imokhonko.model.dao;

import com.imokhonko.model.Client;

public class ClientDAO {

    public static Client getClientByName(String name) {
        if(name.equals("Ivan")) {
            Client client = new Client.Builder().name("Ivan").age(19).build();
            return client;
        }
        return null;
    }

}
