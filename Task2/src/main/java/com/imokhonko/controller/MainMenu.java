package com.imokhonko.controller;

import com.imokhonko.view.ConsoleView;

public class MainMenu extends Controller {

    private ConsoleView view = new ConsoleView();

    @Override
    public void processRequest() {
        view.printMainMenu();
    }
}
