package org._jd.domain;

import org._jd.domain.interfaces.Entity;

public class Ticket implements Entity {
    private static int cnt = 10000000;
    private int id;
    private int busNumber;
    private double cost;

    {
        this.id = ++cnt;
    }

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "busNumber=" + busNumber +
                ", cost=" + cost +
                '}';
    }
}
