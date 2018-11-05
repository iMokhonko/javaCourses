package com.imokhonko.model;

import com.imokhonko.model.exceptions.InvalidCreditMonthsException;
import com.imokhonko.model.exceptions.InvalidCreditSumException;
import com.imokhonko.model.exceptions.NoSuchCreditInBankException;
import com.imokhonko.model.exceptions.UnableOpenCreditException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ClientTest {

    private Client client = null;

    private Bank privat24 = null;
    private Bank universalBank = null;
    private Bank otpBank = null;

    private Credit credit5Percent = null;
    private Credit credit7Percent = null;
    private Credit credit5and5Percent = null;
    private Credit credit1Percent = null;

    @Before
    public void init() throws InvalidCreditSumException, InvalidCreditMonthsException, NoSuchCreditInBankException, UnableOpenCreditException {
        client = new Client.Builder().name("Ivan").age(19).build();

        privat24 = new Bank("Privat24", 10000000);
        universalBank = new Bank("Universal Bank", 10000000);
        otpBank = new Bank("ОТП Банк", 10000000);

        credit5Percent = new Credit.Builder().name("For students").minSum(1000).maxSum(100000).months(12).percents(0.05).build();
        credit7Percent = new Credit.Builder().name("For families").minSum(35000).maxSum(500000).months(36).percents(0.07).build();
        credit5and5Percent = new Credit.Builder().name("Standard").minSum(5000).maxSum(50000).months(12).percents(0.055).payAhead(true).maxMonthIncrease(5).build();
        credit1Percent = new Credit.Builder().name("Premium").minSum(20000).maxSum(1000000).months(12).percents(0.01).build();

        privat24.setAvailableCredits(credit1Percent);
        privat24.setAvailableCredits(credit5and5Percent);
        universalBank.setAvailableCredits(credit7Percent);
        otpBank.setAvailableCredits(credit5Percent);

        privat24.openLoan(new Loan.Builder().client(client).credit(credit1Percent).creditSum(40000).creditMonths(10).build());
        universalBank.openLoan(new Loan.Builder().client(client).credit(credit7Percent).creditSum(40000).creditMonths(10).build());
        otpBank.openLoan(new Loan.Builder().client(client).credit(credit5Percent).creditSum(40000).creditMonths(10).build());
    }

    @After
    public void tearDown() throws Exception {
        client = null;

        privat24 = null;
        universalBank = null;
        otpBank = null;

        credit5Percent = null;
        credit7Percent = null;
        credit5and5Percent = null;
        credit1Percent = null;
    }

    @Test
    public void getMyLoans() {
        int expectedLoansCount = 1;
        int actualLoansCount = client.getMyLoans(privat24).size();

        assertEquals(expectedLoansCount, actualLoansCount);
    }

    @Test
    public void getMyLoans1() {
        int expectedLoansCount = 3;
        int actualLoansCount = client.getMyLoans(Arrays.asList(privat24, otpBank, universalBank)).size();

        assertEquals(expectedLoansCount, actualLoansCount);
    }
}