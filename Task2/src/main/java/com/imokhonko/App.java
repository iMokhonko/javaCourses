package com.imokhonko;

import com.imokhonko.helpers.VehiclesSorting;
import com.imokhonko.vehicles.*;
import com.imokhonko.interfaces.Flyable;
import com.imokhonko.interfaces.Moveable;
import com.imokhonko.interfaces.Swimable;

import java.util.ArrayList;
import java.util.List;

public class App {

    /* List of vehicles */
    private static List<Vehicle> vehicles = new ArrayList<>();

    /* List of Flyable vehicles */
    private static List<Flyable> flyableVehicles = new ArrayList<>();

    /* List of Moveable vehicles */
    private static List<Moveable> moveableVehicles = new ArrayList<>();

    /* List of Swimable vehicles */
    private static List<Swimable> swimableVehicles = new ArrayList<>();


    public static void main(String[] args) {
        fillVehicles(vehicles);

        System.out.println("1. Min price vehicles:");
        VehiclesSorting.printMinPriceVehicles(vehicles);
        System.out.println("_____________________________________________________");

        System.out.println("1. Max speed vehicles: ");
        VehiclesSorting.printMaxSpeedVehicles(vehicles);
        System.out.println("_____________________________________________________");

        System.out.println("1. Vehicles not older than 5 years:");
        VehiclesSorting.printYoungVehicles(vehicles, 5);
        System.out.println("_____________________________________________________");

        System.out.println("2. Planes with altitute more then 5000:");
        VehiclesSorting.printVehiclesWithBiggerAltitude(vehicles, 5000);
        System.out.println("_____________________________________________________");

        System.out.println("2. Planes with release date older than 2000:");
        VehiclesSorting.printVehiclesOlderThanYear(vehicles, 2000);
        System.out.println("_____________________________________________________");

        System.out.println("3. Vehicles (except planes) with speend range 200-500:");
        VehiclesSorting.printVehiclesSpeedRangeExceptPlane(vehicles, 200, 500);
        System.out.println("_____________________________________________________");

        // getting Flyable vehicles
        flyableVehicles = VehiclesSorting.getFlyableVehicles(vehicles);

        // getting Moveable vehicles
        moveableVehicles = VehiclesSorting.getMoveableVehicles(vehicles);

        // getting Swimable vehicles
        swimableVehicles = VehiclesSorting.getSwimableVehicles(vehicles);

        System.out.println("5. Flyable vehicles:");
        flyableVehicles.forEach(System.out::println);
        System.out.println("_____________________________________________________");

        System.out.println("5. Moveable vehicles:");
        moveableVehicles.forEach(System.out::println);
        System.out.println("_____________________________________________________");

        System.out.println("5. Swimable vehicles:");
        swimableVehicles.forEach(System.out::println);
        System.out.println("_____________________________________________________");

        System.out.println("6. Flyable max speed vehicles:");
        VehiclesSorting.printMaxSpeedFlyableVehicles(flyableVehicles);
        System.out.println("_____________________________________________________");

        System.out.println("6. Moveable max speed vehicles:");
        VehiclesSorting.printMaxSpeedMoveableVehicles(moveableVehicles);
        System.out.println("_____________________________________________________");

        System.out.println("6. Swimable max speed vehicles:");
        VehiclesSorting.printMaxSpeedSwimableVehicles(swimableVehicles);
        System.out.println("_____________________________________________________");


    }

    /**
     * Filling list of vehicles.
     * @param vehicles list of vehicles to fill.
     */
    private static void fillVehicles(List<Vehicle> vehicles) {
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
