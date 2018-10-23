package com.imokhonko.controller;

import com.imokhonko.model.Vehicle;
import com.imokhonko.model.helpers.VehiclesFiller;
import com.imokhonko.model.helpers.VehiclesFiltering;
import com.imokhonko.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class AllVehiclesList extends Controller {

    private ConsoleView view = new ConsoleView();
    private VehiclesFiltering model = new VehiclesFiltering();

    @Override
    public void processRequest() {
        List<Vehicle> vehicles = new ArrayList<>();
        VehiclesFiller.fillVehicles(vehicles);
        view.printVehicles(vehicles);
    }
}
