package com.imokhonko;

import com.imokhonko.exceptions.InvalidCreditMonthsException;
import com.imokhonko.exceptions.InvalidCreditSumException;

public class Loan {

    private final Client client;
    private final Credit credit;
    private final double creditSum;
    private final int creditMonths;

    private Loan(Builder builder) throws InvalidCreditSumException, InvalidCreditMonthsException {
        checkCreditSum(builder.creditSum, builder.credit);
        checkCreditMonths(builder.creditMonths, builder.credit);

        this.client = builder.client;
        this.credit = builder.credit;
        this.creditSum = builder.creditSum;
        this.creditMonths = builder.creditMonths;
    }

    public static class Builder {
        private Client client;
        private Credit credit;
        private double creditSum;
        private int creditMonths;

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder credit(Credit credit) {
            this.credit = credit;
            return this;
        }

        public Builder creditSum(double creditSum) {
            this.creditSum = creditSum;
            return this;
        }

        public Builder creditMonths(int creditMonths) {
            this.creditMonths = creditMonths;
            return this;
        }

        public Loan build() throws InvalidCreditSumException, InvalidCreditMonthsException {
            return new Loan(this);
        }
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
