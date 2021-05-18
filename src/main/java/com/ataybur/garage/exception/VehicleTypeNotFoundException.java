package com.ataybur.garage.exception;

public class VehicleTypeNotFoundException extends RuntimeException {
    VehicleTypeNotFoundException(String vehicleType) {
        super("Could not find vehicleType " + vehicleType);
    }
}
