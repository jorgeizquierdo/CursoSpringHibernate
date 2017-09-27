package com.hiberus.api.controller.rest;

import com.hiberus.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jizquierdo.
 */
@RestController
@RequestMapping("/rest/vehicles")
public class RestVehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getVehicles(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "typeName", required = false) String typeName ,
                                         @RequestParam(value = "colorName", required = false) String colorName,
                                         @RequestParam(value = "minPrice", required = false) Float minPrice,
                                         @RequestParam(value = "maxPrice", required = false) Float maxPrice,
                                         @RequestParam(value = "minStock", required = false) int minStock,
                                         @RequestParam(value = "maxStock", required = false) Integer maxStock){

        if(name == null && typeName == null && colorName == null && minPrice == null && maxPrice == null &&
                 maxStock == null){
            return new ResponseEntity<>(vehicleService.getAllUsingHQL(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(vehicleService.getVehicle(name, typeName, colorName, minPrice, maxPrice, minStock,
                    maxStock, false), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getVehicleById(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.getById(id), HttpStatus.OK);
    }

}
