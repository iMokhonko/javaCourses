package com.imokhonko.model;

import com.imokhonko.exceptions.NoSuchCreditInBankException;
import com.imokhonko.exceptions.UnableOpenCreditException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private final String name;

    /* money amount for giving credits to clients */
    private double availableMoneyAmount = 0;

    /* all available credit that bank has */
    private List<Credit> availableCredits = new ArrayList<>();

    /* Opened loans in a bank */
    private List<Loan> loans = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, double availableMoneyAmount) {
        this(name);
        this.availableMoneyAmount = availableMoneyAmount;
    }

    /**
     * @param loan
     * @throws UnableOpenCreditException if client already opened the loan in this bank or bank has not enough money.
     * @throws NoSuchCreditInBankException if bank doesn't have such credit.
     */
    public void openLoan(Loan loan) throws UnableOpenCreditException, NoSuchCreditInBankException {
        checkCreditInBank(loan.getCredit());
        ensureCreditAbility(loan.getCreditSum());
        checkClientForCredits(loan.getClient());
        this.loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * (returns list of one loan, becase client can open only one credit in the bank)
     * @param client
     * @return the list of loans for given client
     */
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

    /**
     * Ensures that bank has enough money to give a credit for a client.
     * @param newSum sum that client wants to take.
     * @throws UnableOpenCreditException if bank can not give such sum to a client.
     */
    private void ensureCreditAbility(double newSum) throws UnableOpenCreditException {
        double creditsSum = 0;
        for(Loan loan : loans) {
            creditsSum += loan.getCreditSum();
        }
        if(creditsSum + newSum > availableMoneyAmount) {
            throw new UnableOpenCreditException("can`t give a credit to client");
        }
    }

    /**
     * Checks if bank has such credit type in a bank.
     * @param credit
     * @throws NoSuchCreditInBankException if bank doesn't have such credit.
     */
    private void checkCreditInBank(Credit credit) throws NoSuchCreditInBankException {
        if(!this.getAvailableCredits().contains(credit)) {
            throw new NoSuchCreditInBankException("There is no such credit (" + credit.getName() + ") in " + this.getName() + " bank");
        }
    }

    /**
     * Checking if client is already opened loan in this bank.
     * @param client
     * @throws UnableOpenCreditException if client already has loan in this bank.
     */
    private void checkClientForCredits(Client client) throws UnableOpenCreditException {
        for(Loan loan : loans) {
            if(loan.getClient().equals(client))
                throw new UnableOpenCreditException("You already opened credit in our bank");
        }
    }

}
