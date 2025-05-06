package org._jd.domain;

public class Bus {
    private int number;
    private int seats;

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
}
