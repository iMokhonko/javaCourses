package com.imokhonko.controller;

import com.imokhonko.App;
import com.imokhonko.model.Vehicle;
import com.imokhonko.model.helpers.VehiclesFiltering;
import com.imokhonko.model.interfaces.Flyable;

import java.util.List;

public class VehiclesController {

    public static List<Vehicle> getAllVehicles() {
        return App.vehicles;
    }

//    public static List<Flyable> getFlyableVehicles() {
////        return VehiclesFiltering.getFlyableVehicles(App.vehicles);
//    }

}
