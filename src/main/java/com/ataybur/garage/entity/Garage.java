package com.ataybur.garage.entity;

import javax.persistence.*;

@Entity
public class Garage {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    private int slot;

    public Garage() {
    }

    public Garage(Vehicle vehicle, int slot) {
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", slot=" + slot +
                '}';
    }
}
