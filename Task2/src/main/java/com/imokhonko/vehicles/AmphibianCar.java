package com.imokhonko.vehicles;

import com.imokhonko.interfaces.Moveable;
import com.imokhonko.interfaces.Swimable;

public class AmphibianCar extends Vehicle
        implements Swimable, Moveable {

    public static class Builder implements javafx.util.Builder<AmphibianCar> {
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

        public AmphibianCar build() {
            return new AmphibianCar(this);
        }
    }

    private AmphibianCar(Builder builder) {
        super(builder.price, builder.maxSpeed, builder.releaseDate);
        this.setCoordinates(builder.coordinates);
    }

    @Override
    public String toString() {
        return "AmphibianCar{" +
                "coordinates=" + this.getCoordinates() + ", " +
                "price=" + this.getPrice() + ", " +
                "maxSpeed=" + this.getMaxSpeed() + ", " +
                "releaseDate=" + this.getReleaseDate() + '}';
    }

}
