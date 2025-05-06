package org._jd.domain;

public class Ticket {
    private int busNumber;
    private double cost;

    public Ticket(int busNumber, double cost) {
        this.busNumber = busNumber;
        this.cost = cost;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public double getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "busNumber=" + busNumber +
                ", cost=" + cost +
                '}';
    }
}
