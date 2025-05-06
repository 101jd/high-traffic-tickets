package org._jd.exceptions;

public class NoBusesException extends RuntimeException{
    public NoBusesException() {
        super("Bus station is empty");
    }
}
