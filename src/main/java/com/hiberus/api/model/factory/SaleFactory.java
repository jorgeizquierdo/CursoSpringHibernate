package com.hiberus.api.model.factory;

import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.model.sale.Sale;
import com.hiberus.api.model.vehicle.Vehicle;

import java.util.Date;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class SaleFactory {

    public static Sale newSale(Customer customer, Vehicle vehicle){

        return SaleFactory.newSale(customer.getId(), vehicle.getId(), vehicle.getPrice());
    }

    public static Sale newSale(int customerId, int vehicleId, float currentPrice){

        Sale sale = new Sale();

        sale.setCustomer(CustomerFactory.customerForRelation(customerId));
        sale.setVehicle(VehicleFactory.vehicleForRelation(vehicleId));
        sale.setPurchaseDate(new Date());
        sale.setPrice(currentPrice);

        return sale;
    }

}