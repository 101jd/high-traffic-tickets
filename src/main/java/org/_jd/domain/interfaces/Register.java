package org._jd.domain.interfaces;

import org._jd.domain.BusTicketOrder;
import org._jd.domain.Ticket;

import java.util.List;

public interface Register {
    void increaseCash(double cash);
    BusTicketOrder releaseTicket(Ticket ticket, double cash);
    List<Ticket> getTickets();
    Station getStation();
}
