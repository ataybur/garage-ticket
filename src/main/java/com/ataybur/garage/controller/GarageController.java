package com.ataybur.garage.controller;

import com.ataybur.garage.entity.Garage;
import com.ataybur.garage.entity.Vehicle;
import com.ataybur.garage.service.GarageService;
import com.ataybur.garage.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {

    private final GarageService garageService;

    GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/status")
    String status() {
        List<Garage> garageList = garageService.getAll();
        if(garageList.isEmpty()) {
            return ResponseUtils.garageIsEmpty();
        }
        List<String> slots = garageService.printSlots(garageList);
        StringBuilder status = new StringBuilder("Status");
        status.append(System.lineSeparator());
        for (String slot : slots) {
            status.append(System.lineSeparator());
            status.append(slot);
        }
        return status.toString();
    }

    @PostMapping("/park")
    String park(@RequestBody Vehicle vehicle) {
        return ResponseUtils.allocationMessage(garageService.park(vehicle));
    }

    @DeleteMapping("/leave/{id}")
    void leave(@PathVariable Long id) {
        garageService.leave(id);
    }
}
