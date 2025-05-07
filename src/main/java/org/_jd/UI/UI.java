package org._jd.UI;

import org._jd.domain.BusTicketOrder;

public interface UI {
    void insertMoney();

    BusTicketOrder buyTicket(int busNumber);

    void menu();

    void init();
}
