package com.imokhonko.model;

import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;
import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoanTest {

    private Client client = null;
    private Credit credit = null;
    private Bank bank = null;

    Loan loan = null;

    @Before
    public void init() throws InvalidCreditSumException, InvalidCreditMonthsException {
        client = new Client.Builder().name("Ivan").age(19).build();
        credit = new Credit.Builder().name("For students").minSum(1000).maxSum(100000).months(12).percents(0.05).build();

        loan = new Loan.Builder().client(client).credit(credit).creditMonths(10).creditSum(25000).build();
    }

    @Test
    public void getFinalSumToPay() {
        double expectedFinalSum = 26250;
        double actualFinalSum = loan.getFinalSumToPay();
        double delta = 0.001;

        assertEquals(expectedFinalSum, actualFinalSum, delta);
    }

    @Test
    public void getMonthSumToPay() {
        double expectedMonthSumToPay = 2625;
        double actualMonthSumToPay = loan.getMonthSumToPay();
        double delta = 0.001;

        assertEquals(expectedMonthSumToPay, actualMonthSumToPay, delta);
    }

    @Test(expected = InvalidCreditMonthsException.class)
    public void loanWithBiggerNumberOfMonthsInCredit__throwsInvalidCreditMonthsException() throws InvalidCreditSumException, InvalidCreditMonthsException {
        new Loan.Builder().client(client).credit(credit).creditSum(35000).creditMonths(13).build();
    }

    @Test(expected = InvalidCreditSumException.class)
    public void loanWithLessValueThanMaxSum__throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException {
        new Loan.Builder().client(client).credit(credit).creditSum(1).creditMonths(5).build();
    }

    @Test(expected = InvalidCreditMonthsException.class)
    public void loanWithZeroMonthsNumber__throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException {
        new Loan.Builder().client(client).credit(credit).creditSum(25000).creditMonths(0).build();
    }

    @Test(expected = InvalidCreditSumException.class)
    public void openLoan_takeSumMoreThanCreditCanOffer_throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        new Loan.Builder().client(client).credit(credit).creditSum(10000000).creditMonths(10).build();
    }

}