package org._jd.domain;

import org._jd.domain.interfaces.Order;

public class BusTicketOrder implements Order {
    private Ticket ticket;
    private double cashBack;

    public BusTicketOrder(Ticket ticket, double cashBack) {
        this.ticket = ticket;
        this.cashBack = cashBack;
    }

    @Override
    public String toString() {
        return "BusTicketOrder{" +
                "ticket=" + ticket.toString() +
                ", cashBack=" + cashBack +
                '}';
    }
}
