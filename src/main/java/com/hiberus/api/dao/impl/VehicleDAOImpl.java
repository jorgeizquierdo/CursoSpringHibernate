package com.hiberus.api.dao.impl;

import com.hiberus.api.dao.VehicleDAO;
import com.hiberus.api.model.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Repository(value = "vehicleDAO")
public class VehicleDAOImpl extends AbstractDAOImpl<Vehicle> implements VehicleDAO {

    protected VehicleDAOImpl() {

        super(Vehicle.class);
    }

}