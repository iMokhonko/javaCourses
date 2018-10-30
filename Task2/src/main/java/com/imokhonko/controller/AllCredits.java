package com.imokhonko.controller;

import com.imokhonko.Credit;
import com.imokhonko.CreditsUtil;
import com.imokhonko.model.dao.BanksDAO;
import com.imokhonko.view.View;

import java.util.List;

public class AllCredits implements Controller {

    BanksDAO banksDAO = new BanksDAO();

    @Override
    public void processRequest() {
        List<Credit> credits = CreditsUtil.getBestCredits(banksDAO.getBanks());
        View.printAllCredits(credits);
    }
}
