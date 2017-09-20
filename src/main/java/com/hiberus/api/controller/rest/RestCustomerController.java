package com.hiberus.api.controller.rest;

import com.hiberus.api.aop.annotation.RegisterLog;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@RestController(value = "restCustomerController")
@RequestMapping("/rest/customer")
public class RestCustomerController {

    @Autowired
    private CustomerService customerService;

    @RegisterLog
    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable String name) {

        return new ResponseEntity(this.getCustomer(name, false), HttpStatus.OK);
    }

    @RegisterLog
    @RequestMapping(value = "/get/{name}/{withSales}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable String name, @PathVariable boolean withSales) {

        return new ResponseEntity(
                this.customerService.getByName(
                        name,
                        (withSales)
                                ? new AbstractDAO.CollectionName[]{Customer.Collection.SALES}
                                : null),
                HttpStatus.OK);
    }

    @RegisterLog
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {

        return new ResponseEntity(this.customerService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/all2", method = RequestMethod.GET)
    public List<Customer> getAll2() {

        return this.customerService.getAll();
    }

    @RegisterLog
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/all/secured", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSecured() {

        return new ResponseEntity(this.customerService.getAll(), HttpStatus.OK);
    }

}