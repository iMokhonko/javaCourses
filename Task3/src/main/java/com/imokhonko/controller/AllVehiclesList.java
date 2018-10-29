package com.imokhonko.controller;

import com.imokhonko.model.Vehicle;
import com.imokhonko.model.util.VehiclesFiller;
import com.imokhonko.model.VehiclesFiltering;
import com.imokhonko.view.ConsoleView;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.imokhonko.model.util.ClassNameUtil.getCurrentClassName;

public class AllVehiclesList extends Controller {

    private static final Logger logger = Logger.getLogger(getCurrentClassName());

    private ConsoleView view = new ConsoleView();
    private VehiclesFiltering model = new VehiclesFiltering();

    @Override
    public void processRequest() {
        List<Vehicle> vehicles = new ArrayList<>();
        VehiclesFiller.fillVehicles(vehicles);

        logger.trace("vehicles filled successfully");

        view.printVehicles(vehicles);
    }
}
