package org._jd.repository;

import org._jd.domain.Bus;
import org._jd.domain.Ticket;
import org._jd.domain.interfaces.Entity;

import java.util.List;

public interface DataAccess {
    void save(Entity entity);
    Entity load(int id);
    Entity delete(Entity entity);
    List<Bus> loadAllBuses();
    List<Ticket> loadAllTickets();
    Bus findBus(int id);
    Ticket findTicket(int id);
}
