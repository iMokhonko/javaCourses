package com.imokhonko.helpers;

import com.imokhonko.vehicles.Plane;
import com.imokhonko.vehicles.Vehicle;
import com.imokhonko.interfaces.Flyable;
import com.imokhonko.interfaces.Moveable;
import com.imokhonko.interfaces.Swimable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VehiclesSorting {

    /**
     * Prints vehicles with min price.
     * @param vehicles list of vehicles.
     */
    public static void printMinPriceVehicles(final List<Vehicle> vehicles) {
        int minPrice = Integer.MAX_VALUE;

        // getting the min price from vehicles list
        for(Vehicle vehicle : vehicles)
            if(vehicle.getPrice() < minPrice)
                minPrice = vehicle.getPrice();

        final int streamMinPrice = minPrice;

//        vehicles.stream()
//                .min(Comparator.comparing(Vehicle::getPrice));

        vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() == streamMinPrice) // filter vehicle with min price
                .forEach(System.out::println);
    }

    /**
     * Prints vehicles with max price.
     * @param vehicles list of vehicles.
     */
    public static void printMaxSpeedVehicles(final List<Vehicle> vehicles) {
        int maxSpeed = 0;

        // getting the max price from list of vehicles
        for(Vehicle vehicle : vehicles)
            if(vehicle.getMaxSpeed() > maxSpeed)
                maxSpeed = vehicle.getMaxSpeed();

        final int streamMaxSpeed = maxSpeed;

        vehicles.stream()
                .filter(vehicle -> vehicle.getMaxSpeed() == streamMaxSpeed) // filter vehicle with max speed
                .forEach(System.out::println);
    }

    /**
     * Prints vehicles that has release date not more than maxYears years from current date.
     * @param vehicles list of vehicles.
     * @param maxYears years.
     */
    public static void printYoungVehicles(final List<Vehicle> vehicles, final int maxYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR); // current year

        vehicles.stream()
                .filter(vehicle -> (currentYear - vehicle.getReleaseDate()) <= maxYears)
                .forEach(System.out::println);
    }

    /**
     * Prints planes with bigger altitude than given altitude.
     * @param vehicles list of vehicles.
     * @param altitude altitude.
     */
    public static void printVehiclesWithBiggerAltitude(final List<Vehicle> vehicles, final int altitude) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getClass() == Plane.class)
                .filter(vehicle -> {
                    Plane plane = (Plane) vehicle;
                    return plane.getMaxAltitude() > altitude;
                }).forEach(System.out::println);
    }

    /**
     * Prints vehicles older than given year.
     * @param vehicles list of vehicles.
     * @param year year.
     */
    public static void printVehiclesOlderThanYear(final List<Vehicle> vehicles, final int year) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getClass() == Plane.class)
                .filter(vehicle -> vehicle.getReleaseDate() > year)
                .forEach(System.out::println);
    }

    /**
     * Prints vehicles in speed range.
     * @param vehicles list of vehicles.
     * @param minSpeedRange min speed range value.
     * @param maxSpeedRange max speed range value.
     */
    public static void printVehiclesSpeedRangeExceptPlane(final List<Vehicle> vehicles,
                                                          final int minSpeedRange,
                                                          final int maxSpeedRange) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getClass() != Plane.class)
                .filter(vehicle -> vehicle.getMaxSpeed() >= minSpeedRange)
                .filter(vehicle -> vehicle.getMaxSpeed() <= maxSpeedRange)
                .forEach(System.out::println);
    }

    /**
     * Getting Flyable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Flyable vehicles.
     */
    public static List<Flyable> getFlyableVehicles(final List<Vehicle> vehicles) {
        List<Flyable> flyableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Flyable) {
                flyableVehicles.add((Flyable) vehicle);
            }
        }

        return flyableVehicles;
    }

    /**
     * Getting Moveable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Moveable vehicles.
     */
    public static List<Moveable> getMoveableVehicles(final List<Vehicle> vehicles) {
        List<Moveable> moveableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Moveable) {
                moveableVehicles.add((Moveable) vehicle);
            }
        }

        return moveableVehicles;
    }

    /**
     * Getting Swmiable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Swiamable vehicles.
     */
    public static List<Swimable> getSwimableVehicles(final List<Vehicle> vehicles) {
        List<Swimable> swimableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Swimable) {
                swimableVehicles.add((Swimable) vehicle);
            }
        }

        return swimableVehicles;
    }

}