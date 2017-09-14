package com.hiberus.api.model.dealership;

import com.hiberus.api.model.vehicle.Vehicle;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Entity(name = "dealership")
@Table(name = "dealership")
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dealership")
    private List<Vehicle> vehicles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}