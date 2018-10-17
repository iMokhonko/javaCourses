package com.imokhonko.helpers;

import com.imokhonko.model.Plane;
import com.imokhonko.model.Vehicle;
import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.model.interfaces.Moveable;
import com.imokhonko.model.interfaces.Swimable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VehiclesSorting {

    /**
     * Prints model with min price.
     * @param vehicles list of model.
     */
    public static void printMinPriceVehicles(final List<Vehicle> vehicles) {
        int minPrice = Integer.MAX_VALUE;

        // getting the min price from model list
        for(Vehicle vehicle : vehicles)
            if(vehicle.getPrice() < minPrice)
                minPrice = vehicle.getPrice();

        final int streamMinPrice = minPrice;

//        model.stream()
//                .min(Comparator.comparing(Vehicle::getPrice));

        vehicles.stream()
                .filter(vehicle -> vehicle.getPrice() == streamMinPrice) // filter vehicle with min price
                .forEach(System.out::println);
    }

    /**
     * Prints model with max price.
     * @param vehicles list of model.
     */
    public static void printMaxSpeedVehicles(final List<Vehicle> vehicles) {
        int maxSpeed = 0;

        // getting the max price from list of model
        for(Vehicle vehicle : vehicles)
            if(vehicle.getMaxSpeed() > maxSpeed)
                maxSpeed = vehicle.getMaxSpeed();

        final int streamMaxSpeed = maxSpeed;

        vehicles.stream()
                .filter(vehicle -> vehicle.getMaxSpeed() == streamMaxSpeed) // filter vehicle with max speed
                .forEach(System.out::println);
    }

    /**
     * Prints model that has release date not more than maxYears years from current date.
     * @param vehicles list of model.
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
     * @param vehicles list of model.
     * @param altitude altitude.
     */
    public static void printVehiclesWithBiggerAltitude(final List<Vehicle> vehicles, final int altitude) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getClass() == Plane.class)
                .filter(vehicle -> ((Plane) vehicle).getMaxAltitude() > altitude)
                .forEach(System.out::println);
    }

    /**
     * Prints model older than given year.
     * @param vehicles list of model.
     * @param year year.
     */
    public static void printVehiclesOlderThanYear(final List<Vehicle> vehicles, final int year) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getClass() == Plane.class)
                .filter(vehicle -> vehicle.getReleaseDate() > year)
                .forEach(System.out::println);
    }

    /**
     * Prints model in speed range.
     * @param vehicles list of model.
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
     * Getting Flyable model.
     * @param vehicles list of all model.
     * @return list of Flyable model.
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
     * Getting Moveable model.
     * @param vehicles list of all model.
     * @return list of Moveable model.
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
     * Getting Swmiable model.
     * @param vehicles list of all model.
     * @return list of Swiamable model.
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

    /**
     * Prints max speed model in Flyable list.
     * @param vehicles list of Flyable model.
     */
    public static void printMaxSpeedFlyableVehicles(final List<Flyable> vehicles) {
        int maxSpeed = 0;

        // getting the max price from list of model
        for(Flyable vehicle : vehicles) {
            if(vehicle instanceof Flyable) {
                if(((Vehicle) vehicle).getMaxSpeed() > maxSpeed)
                    maxSpeed = ((Vehicle) vehicle).getMaxSpeed();
            }
        }

        final int streamMaxSpeed = maxSpeed;

        vehicles.stream()
                .filter(vehicle -> ((Vehicle) vehicle).getMaxSpeed() == streamMaxSpeed) // filter vehicle with max speed
                .forEach(System.out::println);
    }

    /**
     * Prints max speed model in Moveable list.
     * @param vehicles list of Flyable model.
     */
    public static void printMaxSpeedMoveableVehicles(final List<Moveable> vehicles) {
        int maxSpeed = 0;

        // getting the max price from list of model
        for(Moveable vehicle : vehicles) {
            if(vehicle instanceof Moveable) {
                if(((Vehicle) vehicle).getMaxSpeed() > maxSpeed)
                    maxSpeed = ((Vehicle) vehicle).getMaxSpeed();
            }
        }

        final int streamMaxSpeed = maxSpeed;

        vehicles.stream()
                .filter(vehicle -> ((Vehicle) vehicle).getMaxSpeed() == streamMaxSpeed) // filter vehicle with max speed
                .forEach(System.out::println);
    }

    /**
     * Prints max speed model in Moveable list.
     * @param vehicles list of Flyable model.
     */
    public static void printMaxSpeedSwimableVehicles(final List<Swimable> vehicles) {
        int maxSpeed = 0;

        // getting the max price from list of model
        for(Swimable vehicle : vehicles) {
            if(vehicle instanceof Swimable) {
                if(((Vehicle) vehicle).getMaxSpeed() > maxSpeed)
                    maxSpeed = ((Vehicle) vehicle).getMaxSpeed();
            }
        }

        final int streamMaxSpeed = maxSpeed;

        vehicles.stream()
                .filter(vehicle -> ((Vehicle) vehicle).getMaxSpeed() == streamMaxSpeed) // filter vehicle with max speed
                .forEach(System.out::println);
    }

}
