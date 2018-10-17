package com.imokhonko.model;

import com.imokhonko.model.interfaces.Moveable;

public class Car extends Vehicle implements Moveable {

    public static class Builder implements javafx.util.Builder<Car> {
        private Point coordinates;
        private int price;
        private int maxSpeed;
        private int releaseDate;

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

        public Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        super(builder.price, builder.maxSpeed, builder.releaseDate);
        this.setCoordinates(builder.coordinates);
    }

    @Override
    public String toString() {
        return "Car{" +
                "coordinates=" + this.getCoordinates() + ", " +
                "price=" + this.getPrice() + ", " +
                "maxSpeed=" + this.getMaxSpeed() + ", " +
                "releaseDate=" + this.getReleaseDate() + '}';
    }

}
