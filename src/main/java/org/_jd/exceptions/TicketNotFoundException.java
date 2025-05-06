package org._jd.exceptions;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException() {
        super("Ticket not found or already sold");
    }
}
