package com.ataybur.garage.service;

import com.ataybur.garage.entity.Garage;
import com.ataybur.garage.entity.Vehicle;

public interface GarageService extends Printer<Garage> {
    int park(Vehicle vehicle);
    String status();
    void leave(Long vehicleId);
}
