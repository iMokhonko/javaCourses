package com.imokhonko.model;

import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private final String name;
    private double availableMoneyAmount = 0;
    private List<Credit> availableCredits = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, double availableMoneyAmount) {
        this(name);
        this.availableMoneyAmount = availableMoneyAmount;
    }

    public void openLoan(Loan loan) throws UnableOpenCreditException, NoSuchCreditInBankException {
        checkCreditInBank(loan.getCredit());
        ensureCreditAbility(loan.getCreditSum());
        checkClientForCredits(loan.getClient());
        this.loans.add(loan);
    }

    public List<Loan> getClientLoans(final Client client) {
        List<Loan> clientLoans = loans.stream().filter((loan) -> loan.getClient().equals(client))
                .collect(Collectors.toList());

        return clientLoans;
    }

    public void setAvailableCredits(List<Credit> availableCredits) {
        this.availableCredits.addAll(availableCredits);
    }

    public void setAvailableCredits(Credit credit) {
        this.availableCredits.add(credit);
    }

    public List<Credit> getAvailableCredits() {
        return availableCredits;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bank{" + "name='" + name + '\'' + ", availableMoneyAmount=" + availableMoneyAmount + ", availableCredits=" + availableCredits + '}';
    }

    private void ensureCreditAbility(double newSum) throws UnableOpenCreditException {
        double creditsSum = 0;
        for(Loan loan : loans) {
            creditsSum += loan.getCreditSum();
        }
        if(creditsSum + newSum > availableMoneyAmount) {
            throw new UnableOpenCreditException("can`t give a credit to client");
        }
    }

    private void checkCreditInBank(Credit credit) throws NoSuchCreditInBankException {
        if(!this.getAvailableCredits().contains(credit)) {
            throw new NoSuchCreditInBankException("There is no such credit (" + credit.getName() + ") in " + this.getName() + " bank");
        }
    }

    private void checkClientForCredits(Client client) throws UnableOpenCreditException {
        for(Loan loan : loans) {
            if(loan.getClient().equals(client))
                throw new UnableOpenCreditException("You already opened credit in our bank");
        }
    }

}
