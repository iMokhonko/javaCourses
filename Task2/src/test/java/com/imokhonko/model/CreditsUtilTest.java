package com.imokhonko.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CreditsUtilTest {

    private Bank privat24 = null;
    private Bank universalBank = null;
    private Bank otpBank = null;

    private Credit credit5Percent = null;
    private Credit credit7Percent = null;
    private Credit credit5and5Percent = null;
    private Credit credit1Percent = null;

    @Before
    public void init() {
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

    @Test
    public void sortCreditsByPayAhead_returnSortedList() {
        Bank bank1 = new Bank("Privat24", 8989473);
        Bank bank2 = new Bank("Universal Bank", 38912832);

        Credit creditForBank1 = new Credit.Builder().name("For families").minSum(35000).maxSum(500000).months(36).percents(0.07).build();
        Credit creditForBank2 = new Credit.Builder().name("Standard").minSum(5000).maxSum(50000).months(12).percents(0.055).payAhead(true).maxMonthIncrease(5).build();

        bank1.setAvailableCredits(creditForBank1);
        bank2.setAvailableCredits(creditForBank2);

        /* False value goes first, but this method must sort list where true will go before the false values */
        List<Credit> sortedCredits = CreditsUtil.getBestCredits(Arrays.asList(bank1, bank2));

        /* Represent the list of two credits where true values goes first and false values goes after */
        boolean withPayAheadAbility = sortedCredits.get(0).isPayAhed();
        boolean withNoPayAheadAbility = sortedCredits.get(1).isPayAhed();

        assertNotEquals(withPayAheadAbility, withNoPayAheadAbility);
    }

    @Test
    public void sortCreditsByMonthsIncrease_returnSortedList() {
        List<Credit> sortedCredits = CreditsUtil.getBestCredits(Arrays.asList(privat24, universalBank, otpBank));

        for(int i = 1; i < sortedCredits.size(); i++) {
            int prev = sortedCredits.get(i - 1).getMaxMonthIncrease();
            int current = sortedCredits.get(i).getMaxMonthIncrease();

            if(prev < current) {
                fail("the list is not sorted correctly");
            }
        }
    }
}