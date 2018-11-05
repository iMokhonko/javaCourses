package com.imokhonko;

import com.imokhonko.model.Bank;
import com.imokhonko.model.Client;
import com.imokhonko.model.Credit;
import com.imokhonko.model.Loan;
import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;
import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private Client client = null;

    private Bank privat24 = null;
    private Bank universalBank = null;
    private Bank otpBank = null;

    private Credit credit5Percent = null;
    private Credit credit7Percent = null;
    private Credit credit5and5Percent = null;
    private Credit credit1Percent = null;

    @Before
    public void init() {
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
    public void openLoan_openTwoLoansInOneBankByOneClient_throwsUnableOpenCreditException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        privat24.openLoan(new Loan.Builder().client(client).credit(credit1Percent).creditSum(35000).creditMonths(10).build());
        privat24.openLoan(new Loan.Builder().client(client).credit(credit1Percent).creditSum(35000).creditMonths(10).build());
    }

    @Test(expected = UnableOpenCreditException.class)
    public void openLoan_takeLoanWithBiggerCreditSumThatBankHave_throwsUnableOpenCreditException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        otpBank.openLoan(new Loan.Builder().client(client).credit(credit5Percent).creditSum(25000).creditMonths(10).build());

    }

    @Test(expected = NoSuchCreditInBankException.class)
    public void openLoan_takeCreditThatBankDoesNotHave_throwsInvalidCreditSumException() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        universalBank.openLoan(new Loan.Builder().client(client).credit(credit5Percent).creditSum(50000).creditMonths(10).build());
    }

    @Test
    public void openLoanForOneClient_returnListOfOneLoanInABank() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        Client testClient = new Client.Builder().name("LEXA").age(99).build();
        privat24.openLoan(new Loan.Builder().client(testClient).credit(credit5and5Percent).creditSum(35000).creditMonths(10).build());

        int actualSize = privat24.getClientLoans(testClient).size();
        int expectedSize = 1;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void openLoanForTwoClients_returnListOfTwoLoansInABank() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        Client testClient = new Client.Builder().name("LEXA").age(19).build();
        Client testClient2 = new Client.Builder().name("SANYA").age(19).build();
        privat24.openLoan(new Loan.Builder().client(testClient).credit(credit5and5Percent).creditSum(35000).creditMonths(10).build());
        privat24.openLoan(new Loan.Builder().client(testClient2).credit(credit5and5Percent).creditSum(35000).creditMonths(10).build());

        int actualSize = privat24.getLoans().size();
        int expectedSize = 2;

        assertEquals(expectedSize, actualSize);
    }

}