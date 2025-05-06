package org._jd.domain;

import org._jd.domain.interfaces.Station;
import org._jd.exceptions.WrongDataException;

import java.util.List;

public class BusStation implements Station {
    List<Bus> buses;

    public BusStation(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    /**
     *
     * @param busNumber
     * @return bus with number from param or null
     * @throws WrongDataException
     */
    public Bus findBus(int busNumber) throws WrongDataException{
        if (busNumber < 1)
            throw new WrongDataException();

        return buses.stream().filter(bus -> bus.getNumber() == busNumber)
                .findAny().orElse(null);
    }



}
