package com.hiberus.api.model.factory;

import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.model.sale.Sale;

import java.util.Set;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class CustomerFactory {

    public static Customer customerForRelation(int customerId) {

        Customer customer = new Customer();

        customer.setId(customerId);

        return customer;
    }

    public static Customer newCustomer(String name, int gender, int age) {

        return CustomerFactory.newCustomer(name, gender, age, null);
    }

    public static Customer newCustomer(String name, int gender, int age, Set<Sale> sales) {

        Customer customer = new Customer();

        customer.setName(name);
        customer.setGender(gender);
        customer.setAge(age);
        customer.setSales(sales);

        return customer;
    }

}