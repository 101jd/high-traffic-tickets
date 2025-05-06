package org._jd;

public class NoBusesException extends RuntimeException{
    public NoBusesException() {
        super("Bus station is empty");
    }
}
