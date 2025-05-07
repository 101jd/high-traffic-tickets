package org._jd.domain;

import org._jd.domain.interfaces.Entity;

public class Bus implements Entity {
    private static int cnt = 1000;
    private int id;
    private int number;
    private int seats;

    {
        this.id = ++cnt;
    }

    public Bus(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public void decreaseSeats(){
        --seats;
    }

    public int getId() {
        return id;
    }
}
