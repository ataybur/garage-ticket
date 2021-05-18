package com.ataybur.garage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VehicleType {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private int slotHoldingCount;

    public VehicleType(String type, int slotHoldingCount) {
        this.type = type;
        this.slotHoldingCount = slotHoldingCount;
    }

    public VehicleType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSlotHoldingCount() {
        return slotHoldingCount;
    }

    public void setSlotHoldingCount(int slotHoldingCount) {
        this.slotHoldingCount = slotHoldingCount;
    }
}
