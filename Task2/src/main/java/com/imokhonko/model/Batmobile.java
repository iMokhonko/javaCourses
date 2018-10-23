package com.imokhonko.model;

import com.imokhonko.model.interfaces.Flyable;
import com.imokhonko.model.interfaces.Moveable;
import com.imokhonko.model.interfaces.Swimable;

public class Batmobile extends Vehicle
        implements Flyable, Moveable, Swimable {

    public static class Builder {
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

        public Batmobile build() {
            return new Batmobile(this);
        }
    }

    private Batmobile(Builder builder) {
        super(builder.price, builder.maxSpeed, builder.releaseDate, builder.coordinates);
    }

    @Override
    public String toString() {
        return "Batmobile{" +
                "coordinates=" + this.getCoordinates() + ", " +
                "price=" + this.getPrice() + ", " +
                "maxSpeed=" + this.getMaxSpeed() + ", " +
                "releaseDate=" + this.getReleaseDate() + '}';
    }

}
