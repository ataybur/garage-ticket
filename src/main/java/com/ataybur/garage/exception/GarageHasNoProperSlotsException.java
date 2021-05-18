package com.ataybur.garage.exception;

public class GarageHasNoProperSlotsException extends RuntimeException {
    GarageHasNoProperSlotsException() {
        super("Garage is full");
    }
}
