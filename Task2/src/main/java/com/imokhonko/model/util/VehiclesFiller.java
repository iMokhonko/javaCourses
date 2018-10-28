package com.imokhonko.model.util;

import com.imokhonko.model.*;

import java.util.List;

public class VehiclesFiller {

    /**
     * Filling list of vehicles.
     * @param vehicles list of model to fill.
     */
    public static void fillVehicles(List<Vehicle> vehicles) {
        vehicles.add(new Car.Builder()
                .coordinates(new Point(25,69))
                .maxSpeed(150)
                .price(75000)
                .releaseDate(2012)
                .build());

        vehicles.add(new Car.Builder()
                .coordinates(new Point(89,34))
                .maxSpeed(200)
                .price(60000)
                .releaseDate(2013)
                .build());

        vehicles.add(new Car.Builder()
                .coordinates(new Point(13,67))
                .maxSpeed(130)
                .price(2500)
                .releaseDate(2010)
                .build());

        vehicles.add(new Ship.Builder()
                .coordinates(new Point(17,55))
                .maxSpeed(100)
                .price(5000000)
                .releaseDate(1999)
                .port("Kiev port")
                .build());

        vehicles.add(new Ship.Builder()
                .coordinates(new Point(22,5))
                .maxSpeed(150)
                .price(50000)
                .releaseDate(2015)
                .port("Odessa port")
                .build());

        vehicles.add(new Plane.Builder()
                .coordinates(new Point(7,5))
                .maxSpeed(2500)
                .price(750000)
                .releaseDate(2007)
                .maxAltitude(10500)
                .passengersCount(150)
                .build());

        vehicles.add(new Plane.Builder()
                .coordinates(new Point(43,41))
                .maxSpeed(500)
                .price(250000)
                .releaseDate(1990)
                .maxAltitude(10000)
                .passengersCount(15)
                .build());

        vehicles.add(new Plane.Builder()
                .coordinates(new Point(7,5))
                .maxSpeed(300)
                .price(100000)
                .releaseDate(2009)
                .maxAltitude(2000)
                .passengersCount(2)
                .build());

        vehicles.add(new AmphibianCar.Builder()
                .coordinates(new Point(155,13))
                .maxSpeed(60)
                .price(2500)
                .releaseDate(2018)
                .build());

        vehicles.add(new Batmobile.Builder()
                .coordinates(new Point(1,1))
                .maxSpeed(250)
                .price(3000000)
                .releaseDate(2017)
                .build());
    }

}
