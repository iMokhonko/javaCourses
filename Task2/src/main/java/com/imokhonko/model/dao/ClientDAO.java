package com.imokhonko.model.dao;

import com.imokhonko.Client;
import com.imokhonko.exceptions.NoSuchClientException;

public class ClientDAO {

    public static Client getClientByName(String name) throws NoSuchClientException {
        if(name.equals("Ivan")) {
            Client client = new Client.Builder().name("Ivan").age(19).build();
            return client;
        }
        throw new NoSuchClientException("Client doesn't exist!");
    }

}
