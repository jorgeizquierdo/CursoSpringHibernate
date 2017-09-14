package com.hiberus.api.model.sale;

import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.model.vehicle.Vehicle;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Entity(name = "sale")
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Sale(){}

    public Sale(Vehicle vehicle, Customer customer) {
        this.purchaseDate = new Date();
        this.price = vehicle.getPrice();

        this.vehicle = vehicle;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}