package com.ataybur.garage.repository;

import com.ataybur.garage.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GarageRepository extends JpaRepository<Garage,Long> {

    void deleteByVehicleId(Long vehicleId);
}
