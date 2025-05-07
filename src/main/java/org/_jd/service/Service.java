package org._jd.service;

import org._jd.domain.BusTicketOrder;

public interface Service {
    BusTicketOrder sellTicket(int busNumber, double cash);
    void initTickets();
    void initBuses();
}
