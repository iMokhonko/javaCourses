package com.imokhonko.model.util;

import com.imokhonko.model.exceptions.VehicleNotFoundException;
import com.imokhonko.model.exceptions.VehiclesEmptyListException;
import com.imokhonko.model.*;
import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.model.interfaces.Moveable;
import com.imokhonko.model.interfaces.Swimable;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class VehiclesFilteringTest {

    // plane 2, car 2, ship 2
    private final static List<Vehicle> vehicles = new ArrayList<>();

    private VehiclesFiltering vehiclesFiltering;

    @BeforeClass
    public static void setUp() {
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

    @Before
    public void beforeEach() {
        vehiclesFiltering = new VehiclesFiltering();
    }

    @After
    public void afterEach() {
        vehiclesFiltering = null;
    }

    @Test(expected = VehiclesEmptyListException.class)
    public void getMinPriceVehicles_emptyList_throwsVehiclesEmptyListException() {
        List<Vehicle> vehiclesEmptyList = new ArrayList<>();
        vehiclesFiltering.getMinPriceVehicles(vehiclesEmptyList);
    }

    @Test
    public void getMinPriceVehicles_oneMinPriceVehicle_returnListOfOneVehicle() {
        List<Vehicle> list = vehiclesFiltering.getMinPriceVehicles(vehicles);
        int expectedSize = 1;
        assertThat(list).hasSize(expectedSize);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getYoungVehicles_NegativeMaxYearsValue_throwsIllegalArgumentException() {
        vehiclesFiltering.getYoungVehicles(vehicles, -1);
    }

    @Test
    public void getYoungVehicles_oneYearOldVehicles_returnsListOfOneVehicle() {
        List<Vehicle> list = vehiclesFiltering.getYoungVehicles(vehicles, 1);
        int expectedSize = 1;
        assertThat(list).hasSize(expectedSize);

    }

    @Test
    public void getVehiclesWithHigherAltitude_maxAltitudeVehicles_returnListOfTwoVehicles() {
        List<Vehicle> list = vehiclesFiltering.getVehiclesWithHigherAltitude(vehicles, 2000);
        int expectedSize = 2;
        assertThat(list).hasSize(expectedSize);
    }

    @Test
    public void getVehiclesOlderThanYear_olderThan2016Year_returnListOfOneVehicle() {
        List<Vehicle> list = vehiclesFiltering.getVehiclesOlderThanYear(vehicles, 2016);
        int expectedSize = 1;
        assertThat(list).hasSize(expectedSize);
    }

    @Test
    public void getVehiclesSpeedRangeExceptPlane_from200To600_returnListOfOneVehicle() {
        List<Vehicle> list = vehiclesFiltering.getVehiclesSpeedRangeExceptPlane(vehicles, 200, 500);
        int expectedSize = 1;
        assertThat(list).hasSize(expectedSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getVehiclesSpeedRangeExceptPlane_MaxPriceLessThanMinPrice_returnListOfOneVehicle() {
        vehiclesFiltering.getVehiclesSpeedRangeExceptPlane(vehicles, 200, 100);
    }

    @Test
    public void getVehiclesSpeedRangeExceptPlane_vehiclesExceptPlane_returnListOfOneVehicle() {
        List<Vehicle> vehiclesExceptPlane = vehiclesFiltering.getVehiclesSpeedRangeExceptPlane(vehicles, 0, 100000);

        for(Vehicle vehicle : vehiclesExceptPlane) {
            if(vehicle instanceof Plane) {
                fail("plane instance in collection");
            }
        }
    }

    @Test
    public void getFlyableVehicles_getListOfFlyableVehicles_returnListOfFlyableVehicles() throws VehicleNotFoundException {
        List<Flyable> list = vehiclesFiltering.getFlyableVehicles(vehicles);

        assertThat(list).hasOnlyElementsOfType(Flyable.class);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getFlyableVehicles_getEmptyListOfFlyableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
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
        List<Moveable> list = vehiclesFiltering.getMoveableVehicles(vehicles);

        assertThat(list).hasOnlyElementsOfType(Moveable.class);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getMoveableVehicles_getEmptyListOfMoveableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
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
        List<Swimable> list = vehiclesFiltering.getSwimableVehicles(vehicles);

        assertThat(list).hasOnlyElementsOfType(Swimable.class);
    }

    @Test(expected = VehicleNotFoundException.class)
    public void getSwimableVehicles_getListOfSwimableVehicles_throwsVehicleNotFoundException() throws VehicleNotFoundException {
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