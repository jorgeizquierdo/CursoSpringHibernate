package com.hiberus.api.service;

import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.customer.Customer;
import org.hibernate.FetchMode;

import java.util.Collection;
import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
public interface CustomerService {

    void saveCustomers(Collection<Customer> customers);

    void saveCustomersWithWorkAround(Collection<Customer> customers);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer getByName(String name);

    Customer getByName(String name, AbstractDAO.CollectionName[] collectionsToInitialize);

    Customer getByNameWithFavoriteVehicleTypes(String name);

    Customer getByNameWithFavoriteVehicleTypes2(String name);

    Customer getByIdFetchProfileInitialize(int id);

    List<Customer> getAll();

    List<Customer> getAllByMinAgeFilter(int minAge);

    int getNumberOfSales(int id);

}