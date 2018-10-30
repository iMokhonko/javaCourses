package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Client {

    private final String name;
    private final int age;

    private Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Client build() {
            return new Client(name, age);
        }

    }

    public List<Loan> getMyLoans(Bank bank) {
        return bank.getClientLoans(this).stream().collect(Collectors.toList());
    }

    public List<Loan> getMyLoans(List<Bank> banks) {
        List<Loan> clientLoans = new ArrayList<>();
        for(Bank bank : banks) {
            clientLoans.addAll(bank.getClientLoans(this));
        }
        return clientLoans;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Client client = (Client) o;
        return age == client.age
                && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

}
