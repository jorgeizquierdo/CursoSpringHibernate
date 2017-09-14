package com.hiberus.api.service;

import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.vehicle.Vehicle;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public interface VehicleService {

    Vehicle getById(int id);

    Vehicle getByName(String name);

    Vehicle getByName(String name, AbstractDAO.CollectionName[] collectionsToInitialize);

    List<Vehicle> getAllUsingHQL();

    List<Vehicle> getVehicleByMaxCustomerAgeUsingHQL(int age);

    List<Vehicle> getVehicle(String name, String typeName, String colorName, Float minPrice, Float maxPrice,
                             Integer minStock, Integer maxStock, boolean initSales);

    List<Vehicle> getVehicleByExample(Vehicle vehicle);

}