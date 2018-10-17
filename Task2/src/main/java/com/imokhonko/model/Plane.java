package com.imokhonko.model;

import com.imokhonko.model.interfaces.Flyable;

public class Plane extends Vehicle implements Flyable {

    /* Max altitude for the plane */
    private final int maxAltitude;
    /* Max passengers count in the plane */
    private final int passengersCount;

    public static class Builder implements javafx.util.Builder<Plane> {
        private Point coordinates;
        private int price;
        private int maxSpeed;
        private int releaseDate;
        private int maxAltitude;
        private int passengersCount;

        public Builder coordinates(final Point value) {
            this.coordinates = value;
            return this;
        }

        public Builder coordinates(final int x, final int y) {
            this.coordinates = new Point(x, y);
            return this;
        }

        public Builder price(final int price) {
            this.price = price;
            return this;
        }

        public Builder maxSpeed(final int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Builder releaseDate(final int releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder maxAltitude(final int maxAltitude) {
            this.maxAltitude = maxAltitude;
            return this;
        }

        public Builder passengersCount(final int passengersCount) {
            this.passengersCount = passengersCount;
            return this;
        }

        public Plane build() {
            return new Plane(this);
        }
    }

    private Plane(Builder builder) {
        super(builder.price, builder.maxSpeed, builder.releaseDate);
        this.setCoordinates(builder.coordinates);
        this.maxAltitude = builder.maxAltitude;
        this.passengersCount = builder.passengersCount;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "coordinates=" + this.getCoordinates() + ", " +
                "price=" + this.getPrice() + ", " +
                "maxSpeed=" + this.getMaxSpeed() + ", " +
                "releaseDate=" + this.getReleaseDate() + ", " +
                "maxAltitude=" + this.getMaxAltitude() + ", " +
                "passengersCount=" + this.getPassengersCount() + '}';
    }

}
