package com.ataybur.garage;

import com.ataybur.garage.entity.VehicleType;
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
    CommandLineRunner initDatabase(VehicleTypeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new VehicleType("CAR", 1)));
            log.info("Preloading " + repository.save(new VehicleType("JEEP", 2)));
            log.info("Preloading " +  repository.save(new VehicleType("TRUCK", 4)));
        };
    }
}