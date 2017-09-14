package com.hiberus.api.cache.key;

import com.hiberus.api.model.customer.Customer;

/**
 * Created by Daniel on 19/06/2016.
 */
public class CustomerKey {

    public static String customerByName(String name){

        return "customer_" + name;
    }

}