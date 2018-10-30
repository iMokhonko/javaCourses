package com.imokhonko.model.dao;

import com.imokhonko.Bank;
import com.imokhonko.Credit;
import com.imokhonko.CreditsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BanksDAO {

    public List<Bank> getBanks() {

        Bank privat24 = new Bank("Privat24", 1237823);
        Bank universalBank = new Bank("Universal Bank", 38912832);
        Bank otpBank = new Bank("ОТП Банк", 6895433);

        Credit credit5Percent = new Credit.Builder().name("For students").minSum(1000).maxSum(100000).months(12).percents(0.05).build();
        Credit credit7Percent = new Credit.Builder().name("For families").minSum(35000).maxSum(500000).months(36).percents(0.07).payAhead(true).build();
        Credit credit5and5Percent = new Credit.Builder().name("Standard").minSum(5000).maxSum(50000).months(12).percents(0.055).payAhead(true).maxMonthIncrease(5).build();
        Credit credit1Percent = new Credit.Builder().name("Premium").minSum(20000).maxSum(1000000).months(12).percents(0.01).build();

        privat24.setAvailableCredits(credit1Percent);
        privat24.setAvailableCredits(credit5and5Percent);
        universalBank.setAvailableCredits(credit7Percent);
        otpBank.setAvailableCredits(credit5Percent);

        return Arrays.asList(privat24, universalBank, otpBank);
    }

    public List<Credit> findCredit(double sum, int months, double percents) {
        List<Bank> banks = getBanks();
        List<Credit> foundCredits = new ArrayList<>();

        // TODO implement


        return foundCredits;
    }

}
