package com.imokhonko.model;

import java.util.Objects;

public class Credit {

    /* Name of the credit */
    private final String name;

    /* Min sum in this credit */
    private final double minSum;

    /* Max sum in this credit */
    private final double maxSum;

    /* Number of months that client has to pay out the credit */
    private final int months;

    /* Percents that client must pay to bank for this credit */
    private final double percents;

    /* Opportunity to pay out the all credit sum before the deadline */
    private final boolean payAhed;

    /* Opportunity to extend the number of months to pay out the credit */
    private final int maxMonthIncrease;

    private Credit(String name, double minSum, double maxSum, int months,
                   double percents, boolean payAhed, int maxMonthIncrease) {
        this.name = name;
        this.minSum = minSum;
        this.maxSum = maxSum;
        this.months = months;
        this.percents = percents;
        this.payAhed = payAhed;
        this.maxMonthIncrease = maxMonthIncrease;
    }

    public static class Builder {
        private String name;
        private double minSum = 0;
        private double maxSum = 0;
        private int months = 1;
        private double percents = 0.0;
        private boolean payAhed = false;
        private int maxMonthIncrease = 0;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder minSum(double value) {
            this.minSum = value;
            return this;
        }

        public Builder maxSum(double value) {
            this.maxSum = value;
            return this;
        }

        public Builder months(int value) {
            this.months = value;
            return this;
        }

        public Builder percents(double value) {
            this.percents = value;
            return this;
        }

        public Builder payAhead(boolean value) {
            this.payAhed = value;
            return this;
        }

        public Builder maxMonthIncrease(int value) {
            this.maxMonthIncrease = value;
            return this;
        }

        public Credit build() {
            return new Credit(name, minSum, maxSum, months, percents, payAhed, maxMonthIncrease);
        }

    }

    public String getName() {
        return name;
    }

    public double getMinSum() {
        return minSum;
    }

    public double getMaxSum() {
        return maxSum;
    }

    public int getMonths() {
        return months;
    }

    public double getPercents() {
        return percents;
    }

    public boolean isPayAhed() {
        return payAhed;
    }

    public int getMaxMonthIncrease() {
        return maxMonthIncrease;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Credit credit = (Credit) o;
        return Double.compare(credit.minSum, minSum) == 0
                && Double.compare(credit.maxSum, maxSum) == 0
                && months == credit.months
                && Double.compare(credit.percents, percents) == 0
                && payAhed == credit.payAhed
                && maxMonthIncrease == credit.maxMonthIncrease
                && Objects.equals(name, credit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minSum, maxSum, months, percents, payAhed, maxMonthIncrease);
    }

    @Override
    public String toString() {
        return "Credit{" + "name='" + name + '\'' + ", minSum=" + minSum + ", maxSum=" + maxSum + ", months=" + months + ", percents=" + percents + ", payAhed=" + payAhed + ", maxMonthIncrease=" + maxMonthIncrease + '}';
    }
}
