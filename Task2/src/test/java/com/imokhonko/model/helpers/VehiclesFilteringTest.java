package com.imokhonko.model.helpers;

import com.imokhonko.exceptions.VehicleNotFoundException;
import com.imokhonko.exceptions.VehiclesEmptyListException;
import com.imokhonko.model.*;
import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.model.interfaces.Moveable;
import com.imokhonko.model.interfaces.Swimable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VehiclesFilteringTest {

    // plane 2, car 2, ship 2
    private List<Vehicle> vehicles = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        List<Plane> planes = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<Ship> ships = new ArrayList<>();

        planes.add(new Plane.Builder().coordinates(new Point(7,5))
                .maxSpeed(2500)
                .price(750000)
                .releaseDate(2007)
                .maxAltitude(10500)
                .passengersCount(150)
                .build());
        planes.add(new Plane.Builder()
                .coordinates(new Point(43,41))
                .maxSpeed(500)
                .price(250000)
                .releaseDate(1990)
                .maxAltitude(10000)
                .passengersCount(15)
                .build());

        cars.add(new Car.Builder()
                .coordinates(new Point(25,69))
                .maxSpeed(150)
                .price(75000)
                .releaseDate(2017)
                .build());

        cars.add(new Car.Builder()
                .coordinates(new Point(89,34))
                .maxSpeed(200)
                .price(60000)
                .releaseDate(2013)
                .build());

        ships.add(new Ship.Builder()
                .coordinates(new Point(17,55))
                .maxSpeed(100)
                .price(5000000)
                .releaseDate(1999)
                .port("Kiev port")
                .build());

        ships.add(new Ship.Builder()
                .coordinates(new Point(22,5))
                .maxSpeed(150)
                .price(2250)
                .releaseDate(2015)
                .port("Odessa port")
                .build());


        vehicles.addAll(planes);
        vehicles.addAll(cars);
        vehicles.addAll(ships);


    }

    @Test(expected = VehiclesEmptyListException.class)
    public void getMinPriceVehicles_emptyList_throwsVehiclesEmptyListException() {
        List<Vehicle> vehiclesEmptyList = new ArrayList<>();
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> actual = vehiclesFiltering.getMinPriceVehicles(vehiclesEmptyList);
    }

    @Test
    public void getMinPriceVehicles_oneMinPriceVehicle_returnListOfOneVehicle() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> list = vehiclesFiltering.getMinPriceVehicles(vehicles);

        int actualSize = list.size();
        int expectedSize = 1;

        Assert.assertEquals(expectedSize, actualSize);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getYoungVehicles_NegativeMaxYearsValue_throwsIllegalArgumentException() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        vehiclesFiltering.getYoungVehicles(vehicles, -1);
    }

    @Test
    public void getYoungVehicles_oneYearOldVehicles_returnsListOfOneVehicle() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> list = vehiclesFiltering.getYoungVehicles(vehicles, 1);

        int actualSize = list.size();
        int expectedSize = 1;

        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void getVehiclesWithHigherAltitude_maxAltitudeVehicles_returnListOfTwoVehicles() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> list = vehiclesFiltering.getVehiclesWithHigherAltitude(vehicles, 2000);

        int actualSize = list.size();
        int expectedSize = 2;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getVehiclesOlderThanYear_olderThan2016Year_returnListOfOneVehicle() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> list = vehiclesFiltering.getVehiclesOlderThanYear(vehicles, 2016);

        int actualSize = list.size();
        int expectedSize = 1;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getVehiclesSpeedRangeExceptPlane_from200To600_returnListOfOneVehicle() {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> list = vehiclesFiltering.getVehiclesSpeedRangeExceptPlane(vehicles, 200, 500);

        int actualSize = list.size();
        int expectedSize = 1;

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getFlyableVehicles_getListOfFlyableVehicles_returnListOfFlyableVehicles() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Flyable> list = vehiclesFiltering.getFlyableVehicles(vehicles);

        Assert.assertTrue(list.get(0) instanceof Flyable);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getFlyableVehicles_getEmptyListOfFlyableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> listWithoutFlyable = new ArrayList<>();
        listWithoutFlyable.add(new Ship.Builder()
                .coordinates(new Point(17,55))
                .maxSpeed(100)
                .price(5000000)
                .releaseDate(1999)
                .port("Kiev port")
                .build());

        vehiclesFiltering.getFlyableVehicles(listWithoutFlyable);
    }

    @Test
    public void getMoveableVehicles_getListOfMoveableVehicles_returnListOfMoveableVehicles() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Moveable> list = vehiclesFiltering.getMoveableVehicles(vehicles);

        Assert.assertTrue(list.get(0) instanceof Moveable);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getMoveableVehicles_getEmptyListOfMoveableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> listWithoutFlyable = new ArrayList<>();
        listWithoutFlyable.add(new Ship.Builder()
                .coordinates(new Point(17,55))
                .maxSpeed(100)
                .price(5000000)
                .releaseDate(1999)
                .port("Kiev port")
                .build());

        vehiclesFiltering.getFlyableVehicles(listWithoutFlyable);
    }

    @Test
    public void getSwimableVehicles_getListOfSwimableVehicles_returnListOfSwimableVehicles() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Swimable> list = vehiclesFiltering.getSwimableVehicles(vehicles);

        Assert.assertTrue(list.get(0) instanceof Swimable);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getSwimableVehicles_getListOfSwimableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
        VehiclesFiltering vehiclesFiltering = new VehiclesFiltering();
        List<Vehicle> listWithoutFlyable = new ArrayList<>();
        listWithoutFlyable.add(new Plane.Builder().coordinates(new Point(7,5))
                .maxSpeed(2500)
                .price(750000)
                .releaseDate(2007)
                .maxAltitude(10500)
                .passengersCount(150)
                .build());

        vehiclesFiltering.getSwimableVehicles(listWithoutFlyable);
    }

}