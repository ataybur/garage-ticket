package com.ataybur.garage.service.impl;

import com.ataybur.garage.entity.Vehicle;
import com.ataybur.garage.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public String print(Vehicle vehicle) {
        return vehicle.getId() + " "+ vehicle.getPlateNumber() + " "+vehicle.getColour() +" "+vehicle.getVehicleType();
    }
}
