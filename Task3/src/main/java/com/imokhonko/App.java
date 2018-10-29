package com.imokhonko;

import com.imokhonko.controller.Controller;
import com.imokhonko.controller.MainMenu;

public class App {

    public static void main(String[] args) {
        Controller mainMenu = new MainMenu();
        mainMenu.processRequest();
    }
}
