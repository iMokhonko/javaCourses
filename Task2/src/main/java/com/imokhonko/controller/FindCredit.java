package com.imokhonko.controller;

import com.imokhonko.model.Credit;
import com.imokhonko.model.dao.BanksDAO;
import com.imokhonko.view.View;

import java.util.List;

public class FindCredit implements Controller {

    private final double sum;
    private final int months;
    private final double percents;

    public FindCredit(double sum, int months, double percents) {
        this.sum = sum;
        this.months = months;
        this.percents = percents;
    }

    @Override
    public void processRequest() {
        BanksDAO banksDAO = new BanksDAO();
        List<Credit> credits = banksDAO.findCredit(sum, months, percents);
        View.printCredits(credits);
    }
}
