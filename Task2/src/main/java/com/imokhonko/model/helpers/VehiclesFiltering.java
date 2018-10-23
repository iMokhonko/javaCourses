package com.imokhonko.model.helpers;

import com.imokhonko.exceptions.VehicleNotFoundException;
import com.imokhonko.exceptions.VehiclesEmptyListException;
import com.imokhonko.model.Plane;
import com.imokhonko.model.Vehicle;
import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.model.interfaces.Moveable;
import com.imokhonko.model.interfaces.Swimable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehiclesFiltering {

    /**
     * Returns vehicles with min price.
     * @param vehicles list of vehicles.
     */
    public List<Vehicle> getMinPriceVehicles(final List<Vehicle> vehicles) {
        int minPrice;
        try {
            minPrice = vehicles.stream().min((v1, v2) -> v1.getPrice() - v2.getPrice()).get().getPrice();
        } catch(NoSuchElementException e) { minPrice = 0; }

        final int minPredicatePrice = minPrice;
        final Predicate<Vehicle> minPricePredicate = vehicle -> vehicle.getPrice() == minPredicatePrice;
        return getFilteredList(vehicles, minPricePredicate);
    }

    /**
     * Returns vehicles with max price.
     * @param vehicles list of vehicles.
     */
    public List<Vehicle> getMaxSpeedVehicles(final List<Vehicle> vehicles) {
        final int maxSpeed = vehicles.stream()
                .min((v1, v2) -> v1.getMaxSpeed() - v2.getMaxSpeed())
                .get().getPrice();

        final Predicate<Vehicle> maxSpeedPredicate = vehicle -> vehicle.getMaxSpeed() == maxSpeed;

        return getFilteredList(vehicles, maxSpeedPredicate);
    }

    /**
     * Returns vehicles that has release date not more than maxYears years from current date.
     * @param vehicles list of vehicles.
     * @param maxYears represent number of years that filter vehicles.
     * @throws IllegalArgumentException if maxYears is less then zero.
     */
    public List<Vehicle> getYoungVehicles(final List<Vehicle> vehicles,
                                                 int maxYears) throws IllegalArgumentException {
        isNegativeArgumentsInvokeException(maxYears);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Predicate<Vehicle> predicate = vehicle -> (currentYear - vehicle.getReleaseDate()) <= maxYears;

        return getFilteredList(vehicles, predicate);
    }

    /**
     * Returns planes with bigger altitude than given altitude.
     * @param vehicles list of vehicles.
     * @param altitude altitude.
     * @throws IllegalArgumentException if altitude is less then zero.
     */
    public List<Vehicle> getVehiclesWithHigherAltitude(final List<Vehicle> vehicles,
                                                              int altitude) throws IllegalArgumentException {
        isNegativeArgumentsInvokeException(altitude);

        Predicate<Vehicle> predicate = vehicle -> (vehicle.getClass() == Plane.class)
                && (((Plane) vehicle).getMaxAltitude() > altitude);

        return getFilteredList(vehicles, predicate);
    }

    /**
     * Returns vehicles older than given year.
     * @param vehicles list of model.
     * @param year year.
     * @throws IllegalArgumentException if year is less then zero.
     */
    public List<Vehicle> getVehiclesOlderThanYear(final List<Vehicle> vehicles,
                                                         int year) throws IllegalArgumentException {
        isNegativeArgumentsInvokeException(year);

        Predicate<Vehicle> predicate = vehicle -> vehicle.getReleaseDate() > year;

        return getFilteredList(vehicles, predicate);
    }

    /**
     * Returns vehicles in speed range.
     * @param vehicles list of vehicles.
     * @param minSpeedRange min speed range value.
     * @param maxSpeedRange max speed range value.
     */
    public List<Vehicle> getVehiclesSpeedRangeExceptPlane(final List<Vehicle> vehicles,
                                                                 int minSpeedRange,
                                                                 int maxSpeedRange) throws IllegalArgumentException {
        isNegativeArgumentsInvokeException(minSpeedRange, maxSpeedRange);

        Predicate<Vehicle> predicate = vehicle -> (vehicle.getClass() != Plane.class)
                && (vehicle.getMaxSpeed() >= minSpeedRange)
                && (vehicle.getMaxSpeed() <= maxSpeedRange);

        return getFilteredList(vehicles, predicate);
    }

    /**
     * Returns Flyable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Flyable vehicles.
     */
    public List<Flyable> getFlyableVehicles(final List<Vehicle> vehicles) throws VehicleNotFoundException {
        isEmptyListInvokeException(vehicles);

        List<Flyable> flyableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Flyable)
                flyableVehicles.add((Flyable) vehicle);
        }

        if(flyableVehicles.isEmpty())
            throw new VehicleNotFoundException("There is no Flyable vehicles");

        return flyableVehicles;
    }

    /**
     * Returns Moveable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Moveable vehicles.
     */
    public List<Moveable> getMoveableVehicles(final List<Vehicle> vehicles) throws VehicleNotFoundException {
        isEmptyListInvokeException(vehicles);

        List<Moveable> moveableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Moveable) {
                moveableVehicles.add((Moveable) vehicle);
            }
        }

        if(moveableVehicles.isEmpty())
            throw new VehicleNotFoundException("There is no Moveable vehicles");

        return moveableVehicles;
    }

    /**
     * Returns Swmiable vehicles.
     * @param vehicles list of all vehicles.
     * @return list of Swiamable vehicles that has max speed.
     */
    public List<Swimable> getSwimableVehicles(final List<Vehicle> vehicles) throws VehicleNotFoundException {
        isEmptyListInvokeException(vehicles);

        List<Swimable> swimableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof Swimable) {
                swimableVehicles.add((Swimable) vehicle);
            }
        }

        if(swimableVehicles.isEmpty())
            throw new VehicleNotFoundException("There is no Swimable vehicles");

        return swimableVehicles;
    }

    /**
     * If list is empty throws VehiclesEmptyListException (inherited from RuntimeException).
     * @param list list that will be checked.
     */
    private void isEmptyListInvokeException(List list) {
        if(list.isEmpty())
            throw new VehiclesEmptyListException("Empty list of vehicles");
    }

    /**
     * if the given argument is less then zero throws IllegalArgumentException.
     * @param args arguments that will be checked.
     */
    private void isNegativeArgumentsInvokeException(int... args) {
        for(int i = 0; i < args.length; i++) {
            if(args[i] < 0)
                throw new IllegalArgumentException("Negative argument + " + args[i]);
        }
    }

    /**
     * Filters list using filterCondition predicate.
     * @param list list of elements.
     * @param filterCondition condition clause
     * @return new list of elements that matches to condition.
     */
    private <T> List<T> getFilteredList(final List<T> list, Predicate<T> filterCondition) {
        isEmptyListInvokeException(list);
        return list.stream()
                .filter(filterCondition)
                .collect(Collectors.toList());
    }

}
