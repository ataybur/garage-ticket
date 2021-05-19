package com.ataybur.garage.service.impl;

import com.ataybur.garage.entity.Garage;
import com.ataybur.garage.entity.Vehicle;
import com.ataybur.garage.entity.VehicleType;
import com.ataybur.garage.exception.GarageHasNoProperSlotsException;
import com.ataybur.garage.exception.GarageIsFullException;
import com.ataybur.garage.exception.TicketNotFoundException;
import com.ataybur.garage.exception.VehicleTypeNotFoundException;
import com.ataybur.garage.repository.GarageRepository;
import com.ataybur.garage.repository.VehicleRepository;
import com.ataybur.garage.repository.VehicleTypeRepository;
import com.ataybur.garage.service.GarageService;
import com.ataybur.garage.service.VehicleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final static int GARAGE_TOTAL_SLOT = 10;
    private final static int SLOT_TO_NEXT_ONE = 1;
    private final static int FIRST_SLOT = 1;

    private final VehicleRepository vehicleRepository;

    private final GarageRepository garageRepository;

    private final VehicleTypeRepository vehicleTypeRepository;

    private final VehicleService vehicleService;

    GarageServiceImpl(VehicleRepository vehicleRepository, GarageRepository garageRepository, VehicleTypeRepository vehicleTypeRepository, VehicleService vehicleService) {
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.vehicleService = vehicleService;
    }

    @Override
    public String print(Garage garage) {
        Vehicle vehicle = garage.getVehicle();
        StringBuilder stringBuilder = new StringBuilder(vehicleService.print(vehicle));
        stringBuilder.append(" [");
        stringBuilder.append(garage.getSlot());

        VehicleType vehicleType = vehicleTypeRepository.findByType(vehicle.getVehicleType())
                .orElseThrow(() -> new VehicleTypeNotFoundException(vehicle.getVehicleType()));
        for (int i = 1; i < vehicleType.getSlotHoldingCount(); i++) {
            stringBuilder.append(",");
            stringBuilder.append(i + garage.getSlot());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    @Override
    public int park(Vehicle vehicle) {
        final int vehicleSlot = getVehicleSlots(vehicle);
        final List<Integer> blockedSlots = isGarageAvailable(vehicleSlot);
        final int slot = calculateAvailableSlot(blockedSlots, vehicleSlot);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);
        garageRepository.save(new Garage(vehicleSaved, slot));
        return vehicleSlot;
    }

    @Override
    public void leave(Long vehicleId) {
        vehicleRepository
                .findById(vehicleId)
                .orElseThrow(() -> new TicketNotFoundException(vehicleId));
        garageRepository.deleteByVehicleId(vehicleId);
    }

    @Override
    public List<Garage> getAll() {
        return garageRepository.findAll(Sort.by(Sort.Direction.ASC, "slot"));
    }

    @Override
    public List<String> printSlots(List<Garage> garageList) {
        final List<String> slots = new ArrayList<>();
        for (Garage garage : garageList) {
            slots.add(print(garage));
        }
        return slots;
    }

    private List<Integer> isGarageAvailable(final int vehicleSlot) {
        List<Garage> garageList = getAll();
        final int requiredSlot = vehicleSlot + SLOT_TO_NEXT_ONE;
        List<Integer> blockedSlots = new ArrayList<>();
        for (Garage garage : garageList) {
            final int heldVehicleTypeSlots = getVehicleSlots(garage.getVehicle());
            blockedSlots.add(garage.getSlot());
            for (int i = FIRST_SLOT; i <= heldVehicleTypeSlots; i++) {
                blockedSlots.add(garage.getSlot() + i);
            }
        }

        if (GARAGE_TOTAL_SLOT < (blockedSlots.size() + requiredSlot)) {
            throw new GarageIsFullException();
        }
        return blockedSlots;
    }

    private int getVehicleSlots(Vehicle vehicle) {
        final String vehicleTypeName = vehicle.getVehicleType();
        VehicleType vehicleType = vehicleTypeRepository.findByType(vehicleTypeName)
                .orElseThrow(() -> new VehicleTypeNotFoundException(vehicleTypeName));
        return vehicleType.getSlotHoldingCount();
    }

    private int calculateAvailableSlot(final List<Integer> blockedSlots, final int vehicleSlot) {
        for (int i = FIRST_SLOT; i < GARAGE_TOTAL_SLOT; i++) {
            if (!blockedSlots.contains(i)) {
                int required = i + vehicleSlot;
                boolean thereIsAProperSlot = true;
                for (int j = i + 1; j <= required; j++) {
                    if (blockedSlots.contains(j)) {
                        thereIsAProperSlot = false;
                        break;
                    }
                }
                if (thereIsAProperSlot) {
                    return i;
                }
            }

        }
        throw new GarageHasNoProperSlotsException();
    }
}
