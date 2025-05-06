package org._jd.exceptions;

public class NoMoreTicketsException extends RuntimeException{
    public NoMoreTicketsException() {
        super("No more tickets!");
    }
}
