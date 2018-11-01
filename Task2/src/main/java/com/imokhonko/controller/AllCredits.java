package com.imokhonko.controller;

import com.imokhonko.model.Credit;
import com.imokhonko.model.CreditsUtil;
import com.imokhonko.model.dao.BanksDAO;
import com.imokhonko.view.View;

import java.util.List;

public class AllCredits implements Controller {

    BanksDAO banksDAO = new BanksDAO();

    @Override
    public void processRequest() {
        List<Credit> credits = CreditsUtil.getBestCredits(banksDAO.getBanks());
        View.printCredits(credits);
    }
}
