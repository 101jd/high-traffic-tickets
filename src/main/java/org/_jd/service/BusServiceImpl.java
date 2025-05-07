package org._jd.service;

import org._jd.domain.Bus;
import org._jd.domain.BusTicketOrder;
import org._jd.domain.CashRegister;
import org._jd.domain.Ticket;
import org._jd.domain.interfaces.Register;
import org._jd.exceptions.*;
import org._jd.repository.DataAccess;

public class BusServiceImpl implements Service{

    private final Register register;

    private final DataAccess dataAccess;

    public BusServiceImpl(Register register, DataAccess dataAccess) {
        this.register = register;
        this.dataAccess = dataAccess;
    }

    /**
     *
     * @param busNumber
     * @param cash paid money for ticket
     * @return BusTicketOrder with Ticket on requested bus and cashback
     * @throws WrongDataException
     * @throws NotEnoughMoneyException
     * @throws TicketNotFoundException
     * @throws NotEnoughSeatsException
     * @throws BusNotFoundException
     * @throws NoMoreTicketsException
     */
    @Override
    public BusTicketOrder sellTicket(int busNumber, double cash) throws WrongDataException,
            NotEnoughMoneyException, TicketNotFoundException, NotEnoughSeatsException,
            BusNotFoundException, NoMoreTicketsException{
        if (busNumber < 1)
            throw new WrongDataException();
        if (dataAccess.loadAllTickets().isEmpty())
            throw new NoMoreTicketsException();

        Ticket ticket = dataAccess.findTicket(busNumber);

        Bus bus = dataAccess.findBus(busNumber);
        if (bus == null)
            throw new BusNotFoundException();
        if (dataAccess.findBus(busNumber).getSeats() < 1)
            throw new NotEnoughSeatsException();

        bus.decreaseSeats();
        register.increaseCash(cash);
        return register.releaseTicket(ticket, cash);


    }

    @Override
    public void initTickets() {
        for (Ticket ticket : register.getTickets()){
            dataAccess.save(ticket);
        }
    }

    @Override
    public void initBuses() {
        for (Bus bus : register.getStation().getBuses()){
            dataAccess.save(bus);
        }
    }
}
