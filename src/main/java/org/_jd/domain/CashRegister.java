package org._jd;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    private BusStation busStation;
    private List<Ticket> tickets;
    private double cash;

    public CashRegister(BusStation busStation, double cost) {
        this.busStation = busStation;
        this.tickets = new ArrayList<>();
        initTickets(cost);
        this.cash = 0.0;
    }

    private void initTickets(double cost){
        if (busStation.getBuses() == null || busStation.getBuses().size() < 1)
            throw new NoBusesException();
        for (Bus bus : busStation.getBuses()){
            for (int i = 1; i <= bus.getSeats(); i++)
                this.tickets.add(new Ticket(bus.getNumber(), i, cost));
        }
    }
}
