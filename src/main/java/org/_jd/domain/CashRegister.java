package org._jd.domain;

import org._jd.domain.interfaces.Register;
import org._jd.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CashRegister implements Register {
    private BusStation busStation;
    private List<Ticket> tickets;
    private double cash;
    private double cost;

    public CashRegister(BusStation busStation, double cost) throws NoBusesException {
        this.busStation = busStation;
        this.tickets = new ArrayList<>();
        this.cost = cost;
        initTickets(cost);
        this.cash = 0.0;
    }

    private void initTickets(double cost) throws NoBusesException{
        if (busStation.getBuses() == null || busStation.getBuses().size() < 1)
            throw new NoBusesException();
        for (Bus bus : busStation.getBuses()){
            for (int i = 1; i <= bus.getSeats(); i++)
                this.tickets.add(new Ticket(bus.getNumber(), cost));
        }
    }

    private BusTicketOrder releaseTicket(Ticket ticket, double cash) throws NotEnoughMoneyException,
            TicketNotFoundException{
        if (cash < ticket.getCost())
            throw new NotEnoughMoneyException();
        if (!tickets.contains(ticket))
            throw new TicketNotFoundException();
        if (ticket == null)
            throw new TicketNotFoundException();

        tickets.remove(ticket);

        return new BusTicketOrder(ticket, cash - this.cost);
    }

    private Ticket findTicket(int busNumber) throws WrongDataException{
        if (busNumber < 1)
            throw new WrongDataException();
        return tickets.stream().filter(ticket -> ticket.getBusNumber() == busNumber).findAny().orElse(null);
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
    public BusTicketOrder sellTicket(int busNumber, double cash) throws WrongDataException,
            NotEnoughMoneyException, TicketNotFoundException, NotEnoughSeatsException,
            BusNotFoundException, NoMoreTicketsException{
        if (busNumber < 1)
            throw new WrongDataException();
        if (tickets.isEmpty())
            throw new NoMoreTicketsException();

        Ticket ticket = findTicket(busNumber);

        Bus bus = busStation.findBus(busNumber);
        if (bus == null)
            throw new BusNotFoundException();
        if (busStation.findBus(busNumber).getSeats() < 1)
            throw new NotEnoughSeatsException();

        bus.decreaseSeats();
        increaseCash(cash);
        return releaseTicket(ticket, cash);


    }

    private void increaseCash(double cash){
        this.cash =+ cash;
    }
}
