package com.ataybur.garage.exception;

public class GarageHasNoProperSlotsException extends RuntimeException {
    public GarageHasNoProperSlotsException() {
        super("Garage has no proper slots");
    }
}
