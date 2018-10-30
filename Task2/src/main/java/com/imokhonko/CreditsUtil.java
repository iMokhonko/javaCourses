package com.imokhonko;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreditsUtil {

    public static List<Credit> getBestCredits(List<Bank> banks) {
        List<Credit> bestCredits = new ArrayList<>();

        for(Bank bank : banks) {
            bestCredits.addAll(bank.getAvailableCredits());
        }

        /* sort by ability to pay ahead */
        bestCredits.sort((o1, o2) -> {
            if(o1.isPayAhed() == true && o2.isPayAhed() == false) {
                return -1;
            } else if(o1.isPayAhed() == false && o2.isPayAhed() == true) {
                return 1;
            } else {
                return 0;
            }
        });

        /* sort by value of month increase */
        bestCredits.sort((o1, o2) -> o2.getMaxMonthIncrease() - o1.getMaxMonthIncrease());

        return bestCredits;
    }

}
