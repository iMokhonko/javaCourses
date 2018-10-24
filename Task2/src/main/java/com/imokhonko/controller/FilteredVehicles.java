package com.imokhonko.controller;

import com.imokhonko.model.exceptions.VehicleNotFoundException;
import com.imokhonko.model.Vehicle;
import com.imokhonko.model.helpers.VehiclesFiller;
import com.imokhonko.model.VehiclesFiltering;
import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class FilteredVehicles extends Controller {

    private ConsoleView view = new ConsoleView();
    private VehiclesFiltering model = new VehiclesFiltering();

    private String type;

    public FilteredVehicles(String type) {
        this.type = type;
    }

    @Override
    public void processRequest() {
        List<Vehicle> vehicles = new ArrayList<>();
        VehiclesFiller.fillVehicles(vehicles);
        switch(type) {
            case "minPriceVehicls": {
                List<Vehicle> filteredVehicles = model.getMinPriceVehicles(vehicles);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "higherAltitudeVehicles": {
                List<Vehicle> filteredVehicles = model.getVehiclesWithHigherAltitude(vehicles, 5000);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "speedRangeVehicles": {
                List<Vehicle> filteredVehicles = model.getVehiclesSpeedRangeExceptPlane(vehicles, 200, 500);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "flyableVehicles": {
                List<Flyable> filteredVehicles = null;
                try {
                    filteredVehicles = model.getFlyableVehicles(vehicles);
                } catch(VehicleNotFoundException e) {
                    // logger
                }
                view.printFilteredVehicles(filteredVehicles);
            }
        }
    }
}
