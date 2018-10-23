package com.imokhonko.controller;

import com.imokhonko.exceptions.VehicleNotFoundException;
import com.imokhonko.model.Vehicle;
import com.imokhonko.model.helpers.VehiclesFiller;
import com.imokhonko.model.helpers.VehiclesFiltering;
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
                System.out.println("Vehicles with min price:");
                List<Vehicle> filteredVehicles = model.getMinPriceVehicles(vehicles);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "higherAltitudeVehicles": {
                System.out.println("Vehicles with altitude higher than 5000:");
                List<Vehicle> filteredVehicles = model.getVehiclesWithHigherAltitude(vehicles, 5000);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "speedRangeVehicles": {
                System.out.println("Vehicles with altitude higher than 5000:");
                List<Vehicle> filteredVehicles = model.getVehiclesSpeedRangeExceptPlane(vehicles, 200, 500);
                view.printFilteredVehicles(filteredVehicles);
            }
            case "flyableVehicles": {
                System.out.println("Flyable vehicles:");
                List<Flyable> filteredVehicles = null;
                try {
                    filteredVehicles = model.getFlyableVehicles(vehicles);
                } catch(VehicleNotFoundException e) { }
                view.printFilteredVehicles(filteredVehicles);
            }
        }
    }
}
