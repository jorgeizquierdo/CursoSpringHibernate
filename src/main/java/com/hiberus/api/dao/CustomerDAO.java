package com.hiberus.api.dao;

import com.hiberus.api.model.customer.Customer;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public interface CustomerDAO extends AbstractDAO<Customer> {

    List<Customer> greaterThan(int age);

    int getNumberOfSales(int id);

}