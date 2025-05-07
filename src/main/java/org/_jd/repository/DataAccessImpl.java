package org._jd.repository;

import org._jd.domain.Bus;
import org._jd.domain.Ticket;
import org._jd.domain.interfaces.Entity;
import org._jd.exceptions.DataAccessEcxeption;
import org._jd.exceptions.NoBusesException;
import org._jd.exceptions.NoMoreTicketsException;

import java.util.List;
import java.util.stream.Collectors;

public class DataAccessImpl implements DataAccess{
    private final Repo repo;

    public DataAccessImpl(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void save(Entity entity) {
        validate(entity);
        repo.save(entity);
    }

    @Override
    public Entity load(int id) {
        Entity entity = repo.load(id);
        validate(entity);
        return entity;
    }

    @Override
    public Entity delete(Entity entity) {
        validate(entity);
        return repo.delete(entity);
    }

    @Override
    public List<Bus> loadAllBuses() {
        List<Bus> buses = repo.loadAll().stream().filter(entity -> entity instanceof Bus)
                .map(entity -> (Bus) entity)
                .collect(Collectors.toList());

        if (buses.isEmpty() || buses == null)
            throw new NoBusesException();
        return buses;
    }

    @Override
    public List<Ticket> loadAllTickets() {
        List<Ticket> tickets = repo.loadAll().stream().filter(entity -> entity instanceof Ticket)
                .map(entity -> (Ticket)entity)
                .collect(Collectors.toList());

        if (tickets.isEmpty() || tickets == null)
            throw new NoMoreTicketsException();

        return tickets;
    }

    @Override
    public Bus findBus(int id) {
        Bus bus = loadAllBuses().stream().filter(b -> b.getNumber() == id)
                .findAny().orElse(null);
        validate(bus);
        return bus;
    }

    @Override
    public Ticket findTicket(int id) {
        Ticket ticket = loadAllTickets().stream().filter(t -> t.getBusNumber() == id)
                .findAny().orElse(null);

        validate(ticket);

        return ticket;
    }

    private void validate(Entity entity){
        if (entity == null)
            throw new DataAccessEcxeption();
    }

}
