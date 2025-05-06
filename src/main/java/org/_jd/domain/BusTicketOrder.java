package org._jd.domain;

public class BusTicketOrder {
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
