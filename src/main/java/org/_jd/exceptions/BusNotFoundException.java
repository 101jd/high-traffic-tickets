package org._jd.exceptions;

public class BusNotFoundException extends RuntimeException{
    public BusNotFoundException() {
        super("Bus not found!");
    }
}
