package com.ataybur.garage.controller;

import com.ataybur.garage.entity.Vehicle;
import com.ataybur.garage.service.GarageService;
import com.ataybur.garage.utils.MessageUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class GarageController {

    private final GarageService garageService;

    GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/status")
    String status() {
        return garageService.status();
    }

    @PostMapping("/park")
    String park(@RequestBody Vehicle vehicle) {
        return MessageUtils.allocationMessage(garageService.park(vehicle));
    }

    @DeleteMapping("/leave/{id}")
    void leave(@PathVariable Long id) {
        garageService.leave(id);
    }
}
