package com.hiberus.vehicle;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.model.vehicle.Color;
import com.hiberus.api.model.vehicle.Vehicle;
import com.hiberus.api.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class VehicleTest extends AppContextConfigurationAware {

    @Autowired
    private VehicleService vehicleService;

    @Test
    public void fetchingVehicle() {

        Vehicle vehicle = this.vehicleService.getByName("Car1");

        Assert.assertTrue(vehicle != null);
    }

    @Test
    public void getAllUsingHQL() {
        List<Vehicle> vehicleList = this.vehicleService.getAllUsingHQL();

        Assert.assertTrue(vehicleList != null);
    }

    @Test
    public void getVehicleByMaxCustomerAgeUsingHQL() {
        List<Vehicle> vehicleList = this.vehicleService.getVehicleByMaxCustomerAgeUsingHQL(30);

        Assert.assertTrue(vehicleList != null);
    }

    @Test
    public void getVehicleByColumnValues() {
        List<Vehicle> vehicleList = this.vehicleService.getVehicle(null, null, null, null, null, null, null, false);
        List<Vehicle> vehicleList2 = this.vehicleService.getVehicle("car", null, null, null, null, null, null, false);
        List<Vehicle> vehicleList3 = this.vehicleService.getVehicle("other", "car", null, null, null, null, null, false);
        List<Vehicle> vehicleList4 = this.vehicleService.getVehicle("car", null, "RED", null, null, null, null, false);
        List<Vehicle> vehicleList5 = this.vehicleService.getVehicle(null, null, null, null, null, 9, null, true);

        Assert.assertTrue(vehicleList != null && vehicleList2 != null && vehicleList3 != null &&
                vehicleList4 != null && vehicleList5 != null);
    }

    @Test
    public void getVehicleByExample() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("%car%");

        Color color = new Color();
        color.setName("Red");
        vehicle.setColor(color);

        List<Vehicle> vehicleList = this.vehicleService.getVehicleByExample(vehicle);

        Assert.assertTrue(vehicleList != null);
    }

    @Test
    public void getById() {
        Vehicle vehicle = this.vehicleService.getById(1);

        Assert.assertTrue(vehicle != null);
    }

}