package com.hiberus.api.model.factory;

import com.hiberus.api.model.vehicle.Vehicle;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class VehicleFactory {

    public static Vehicle vehicleForRelation(int vehicleId) {

        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleId);

        return vehicle;
    }

}