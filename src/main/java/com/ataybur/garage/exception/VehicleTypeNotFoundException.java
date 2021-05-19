package com.ataybur.garage.exception;

public class VehicleTypeNotFoundException extends RuntimeException {
    public VehicleTypeNotFoundException(String vehicleType) {
        super("Could not find vehicleType " + vehicleType);
    }
}
