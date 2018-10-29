package com.imokhonko.model;

import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;

public class Loan {

    private final Client client;
    private final Credit credit;
    private final double creditSum;
    private final int creditMonths;

    public Loan(Client client, Credit credit, double creditSum, int creditMonths) throws InvalidCreditSumException, InvalidCreditMonthsException {
        checkCreditSum(creditSum, credit);
        checkCreditMonths(creditMonths, credit);

        this.client = client;
        this.credit = credit;
        this.creditSum = creditSum;
        this.creditMonths = creditMonths;
    }

    public Credit getCredit() {
        return credit;
    }

    public double getCreditSum() {
        return creditSum;
    }

    public Client getClient() {
        return client;
    }

    public int getCreditMonths() {
        return creditMonths;
    }

    public double getFinalSumToPay() {
        return creditSum + (creditSum * credit.getPercents());
    }

    public double getMonthSumToPay() {
        return getFinalSumToPay() / creditMonths;
    }

    private void checkCreditSum(double creditSum, Credit credit) throws InvalidCreditSumException {
        if(creditSum < credit.getMinSum()) {
            throw new InvalidCreditSumException("credit sum can`t be less than min credit sum value = " + credit.getMinSum());
        }
        if(creditSum > credit.getMaxSum()) {
            throw new InvalidCreditSumException("credit sum can`t be more than max credit sum value = " + credit.getMaxSum());
        }
    }

    private void checkCreditMonths(int creditMonths, Credit credit) throws InvalidCreditMonthsException {
        if(creditMonths > credit.getMonths()) {
            throw new InvalidCreditMonthsException("Credit months count can`t be more than max value = " + credit.getMonths());
        }
        if(creditMonths < 0) {
            throw new IllegalArgumentException("creditMonths can`t be less than zero");
        }
    }



    @Override
    public String toString() {
        return "Loan{" + "client=" + client + ", credit=" + credit + ", creditSum=" + creditSum + ", creditMonths=" + creditMonths + '}';
    }
}
