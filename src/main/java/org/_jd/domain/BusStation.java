package org._jd;

import java.util.List;

public class BusStation {
    List<Bus> buses;

    public BusStation(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Bus> getBuses() {
        return buses;
    }
}
