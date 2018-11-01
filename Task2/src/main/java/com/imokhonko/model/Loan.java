package com.imokhonko.model;

import com.imokhonko.exceptions.InvalidCreditMonthsException;
import com.imokhonko.exceptions.InvalidCreditSumException;

public class Loan {

    /* Client that take the credit */
    private final Client client;

    /* Credit that client want to take */
    private final Credit credit;

    /* The money sum that client want to take */
    private final double creditSum;

    /* The number of months that client will be paying off the credit */
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

    /**
     * Ensures that requested sum is suitable for given credit.
     * @param creditSum the sum of money that client want to take.
     * @param credit
     * @throws InvalidCreditSumException if client requested sum that less the min sum or more in the credit conditions.
     */
    private void checkCreditSum(double creditSum, Credit credit) throws InvalidCreditSumException {
        if(creditSum < credit.getMinSum()) {
            throw new InvalidCreditSumException("credit sum can`t be less than min credit sum value = " + credit.getMinSum());
        }
        if(creditSum > credit.getMaxSum()) {
            throw new InvalidCreditSumException("credit sum can`t be more than max credit sum value = " + credit.getMaxSum());
        }
    }

    /**
     * Ensures that requested months number is suitable for given credit.
     * @param creditMonths the number of a months for paying off the credit final sum.
     * @param credit
     * @throws InvalidCreditMonthsException if number of months is less or more in the credit conditions.
     */
    private void checkCreditMonths(int creditMonths, Credit credit) throws InvalidCreditMonthsException {
        if(creditMonths > credit.getMonths()) {
            throw new InvalidCreditMonthsException("Credit months count can`t be more than max value = " + credit.getMonths());
        }
        if(creditMonths < 1) {
            throw new InvalidCreditMonthsException("creditMonths can`t be less than zero");
        }
    }

    @Override
    public String toString() {
        return "Loan{" + "client=" + client + ", credit=" + credit + ", creditSum=" + creditSum + ", creditMonths=" + creditMonths + '}';
    }
}
