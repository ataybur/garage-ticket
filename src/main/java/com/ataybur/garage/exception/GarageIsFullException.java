package com.ataybur.garage.exception;

public class GarageIsFullException extends RuntimeException {
    GarageIsFullException() {
        super("Garage is full");
    }
}
