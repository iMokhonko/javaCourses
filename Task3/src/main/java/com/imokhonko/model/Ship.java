package com.imokhonko.model;

import com.imokhonko.model.interfaces.Swimable;

public class Ship extends Vehicle implements Swimable {

    /* Port where ship registered */
    private final String port;

    public static class Builder {
        private Point coordinates;
        private int price;
        private int maxSpeed;
        private int releaseDate;
        private String port;

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

        public Builder port(final String port) {
            this.port = port;
            return this;
        }

        public Ship build() {
            return new Ship(this);
        }
    }

    private Ship(Builder builder) {
        super(builder.price, builder.maxSpeed, builder.releaseDate, builder.coordinates);
        this.port = builder.port;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "coordinates=" + this.getCoordinates() + ", " +
                "price=" + this.getPrice() + ", " +
                "maxSpeed=" + this.getMaxSpeed() + ", " +
                "releaseDate=" + this.getReleaseDate() + ", " +
                "port='" + this.getPort() + '}';
    }

}
