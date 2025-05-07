package org._jd.domain.interfaces;

import org._jd.domain.Bus;

import java.util.List;

public interface Station {
    List<Bus> getBuses();
    Bus findBus(int busNumber);
}
