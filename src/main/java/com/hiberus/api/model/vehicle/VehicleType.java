package com.hiberus.api.model.vehicle;

import com.hiberus.api.model.customer.Customer;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Entity(name = "vehicleType")
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "favoritesVehicleTypes")
    private Set<Customer> customers;

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

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}