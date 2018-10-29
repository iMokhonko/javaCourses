package com.imokhonko.model;

public abstract class Vehicle {

    /* Vehicle coordinates */
    private Point coordinates;

    /* Vehicle price */
    private final int price;

    /* Vehicle max speed */
    private final int maxSpeed;

    /* Vehicle release date */
    private final int releaseDate;

    public Vehicle(int price, int speed, int releaseDate, Point coordinates) {
        this.price = price;
        this.maxSpeed = speed;
        this.releaseDate = releaseDate;
        this.coordinates = coordinates;
    }

    public Vehicle(int price, int speed, int releaseDate) {
        this(price, speed, releaseDate, new Point(0,0));
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "coordinates=" + coordinates + ", " +
                "price=" + price + ", " +
                "maxSpeed=" + maxSpeed + ", " +
                "releaseDate=" + releaseDate + '}';
    }

}
