package com.hiberus.api.controller.rest;

import com.hiberus.api.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel Pardo Ligorred.
 */
@RestController(value = "restCounterController")
@RequestMapping("/rest/counter")
public class RestCounterController {

    @Autowired
    private CounterService counterService;

    @RequestMapping(value = "/safe/{times}", method = RequestMethod.GET)
    public ResponseEntity<?> counter(@PathVariable int times) {

        return new ResponseEntity(this.counterService.addSafeTimes(times), HttpStatus.OK);
    }

    @RequestMapping(value = "/unsafe/{times}", method = RequestMethod.GET)
    public ResponseEntity<?> counterTwo(@PathVariable int times) {

        return new ResponseEntity(this.counterService.addUnsafeTimes(times), HttpStatus.OK);
    }

}