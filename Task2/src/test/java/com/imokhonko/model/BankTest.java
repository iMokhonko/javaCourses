package com.imokhonko.model;

import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;
import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    private static Client client = null;

    private static Bank privat24 = null;
    private static Bank universalBank = null;
    private static Bank otpBank = null;

    private static Credit credit5Percent = null;
    private static Credit credit7Percent = null;
    private static Credit credit5and5Percent = null;
    private static Credit credit1Percent = null;

    @BeforeClass
    public static void init() {
        client = new Client.Builder().name("Ivan").age(19).build();

        privat24 = new Bank("Privat24", 8989473);
        universalBank = new Bank("Universal Bank", 38912832);
        otpBank = new Bank("ОТП Банк", 500);

        credit5Percent = new Credit.Builder().name("For students").minSum(1000).maxSum(100000).months(12).percents(0.05).build();
        credit7Percent = new Credit.Builder().name("For families").minSum(35000).maxSum(500000).months(36).percents(0.07).build();
        credit5and5Percent = new Credit.Builder().name("Standard").minSum(5000).maxSum(50000).months(12).percents(0.055).payAhead(true).maxMonthIncrease(5).build();
        credit1Percent = new Credit.Builder().name("Premium").minSum(20000).maxSum(1000000).months(12).percents(0.01).build();

        privat24.setAvailableCredits(credit1Percent);
        privat24.setAvailableCredits(credit5and5Percent);
        universalBank.setAvailableCredits(credit7Percent);
        otpBank.setAvailableCredits(credit5Percent);
    }

    @Test(expected = UnableOpenCreditException.class)
    public void openLoan_openTwoLoansInOneBank_throwsUnableOpenCreditException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        privat24.openLoan(new Loan(client, credit1Percent, 35000, 10));
        privat24.openLoan(new Loan(client, credit1Percent, 35000, 10));
    }

    @Test(expected = UnableOpenCreditException.class)
    public void openLoan_takeLoanWithBiggerCreditSumThatBankHave_throwsUnableOpenCreditException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        otpBank.openLoan(new Loan(client, credit5Percent, 25000, 10));
    }

    @Test(expected = InvalidCreditSumException.class)
    public void openLoan_takeSumMoreThanCreditCanOffer_throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        universalBank.openLoan(new Loan(client, credit7Percent, 10000000, 10));
    }

    @Test(expected = NoSuchCreditInBankException.class)
    public void openLoan_takeCreditThatBankDoesNotHave_throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        universalBank.openLoan(new Loan(client, credit5Percent, 50000, 10));
    }

    @Test(expected = InvalidCreditMonthsException.class)
    public void loanWithBiggerValueOfMonthsInCredit__throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        new Loan(client, credit1Percent, 35000, 13);
    }

    @Test(expected = InvalidCreditSumException.class)
    public void loanWithLessValueThanMaxSum__throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        new Loan(client, credit1Percent, 1, 5);
    }

    @Test
    public void openLoad_returnListOfOneLoanInABank() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        Client testClient = new Client.Builder().name("LEXA").age(99).build();
        privat24.openLoan(new Loan(testClient, credit5and5Percent, 35000, 10));

        int actualSize = privat24.getClientLoans(testClient).size();
        int expectedSize = 1;

        assertEquals(expectedSize, actualSize);
    }

}