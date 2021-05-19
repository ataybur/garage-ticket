package com.ataybur.garage.exception;

public class GarageIsFullException extends RuntimeException {
    public GarageIsFullException() {
        super("Garage is full");
    }
}
