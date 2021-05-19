package com.ataybur.garage.service;

import com.ataybur.garage.entity.Garage;
import com.ataybur.garage.entity.Vehicle;

import java.util.List;

public interface GarageService extends Printer<Garage> {
    int park(Vehicle vehicle);
    void leave(Long vehicleId);
    List<Garage> getAll();
    List<String> printSlots(List<Garage> garageList);
}
