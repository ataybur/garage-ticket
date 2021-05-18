package com.ataybur.garage;

import com.ataybur.garage.entity.Garage;
import com.ataybur.garage.entity.Vehicle;
import com.ataybur.garage.entity.VehicleType;
import com.ataybur.garage.repository.GarageRepository;
import com.ataybur.garage.repository.VehicleRepository;
import com.ataybur.garage.repository.VehicleTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(VehicleTypeRepository repository, VehicleRepository vehicleRepository, GarageRepository garageRepository) {

        return args -> {
            VehicleType car = repository.save(new VehicleType("CAR", 1));
            VehicleType jeep = repository.save(new VehicleType("JEEP", 2));
            VehicleType truck = repository.save(new VehicleType("TRUCK", 4));
            log.info("Preloading " + car);
            log.info("Preloading " + jeep);
            log.info("Preloading " + truck);
            Vehicle vehicleCar = vehicleRepository.save(new Vehicle("platenumber1","blue","CAR"));
            Vehicle vehicleCar2 = vehicleRepository.save(new Vehicle("platenumber2","red","CAR"));
            Vehicle vehicleTruck = vehicleRepository.save(new Vehicle("platenumber3","black","TRUCK"));
            garageRepository.save(new Garage(vehicleCar,1));
            garageRepository.save(new Garage(vehicleCar2,3));
            garageRepository.save(new Garage(vehicleTruck,5));
        };
    }
}