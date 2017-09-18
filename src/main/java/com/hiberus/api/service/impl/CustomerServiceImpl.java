package com.hiberus.api.service.impl;

import com.hiberus.api.cache.CacheRegion;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.dao.CustomerDAO;
import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.service.CustomerService;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Service("customerService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

    public final static String CUSTOMER_KEY = "com.hiberus.api.cache.key.CustomerKey";

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void saveCustomers(Collection<Customer> customers) {

        for (Customer customer : customers) this.saveCustomer(customer);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void saveCustomersWithWorkAround(Collection<Customer> customers) {

        // Get it's same instance from the application context, to ensure the call is
        // fired throught the bean proxy and @Transactional works properly.
        CustomerService $customerService = this.applicationContext.getBean(CustomerService.class);

        for (Customer customer : customers) $customerService.saveCustomer(customer);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void saveCustomer(Customer customer) {

        try {

            this.customerDAO.save(customer);
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void updateCustomer(Customer customer) {

        this.customerDAO.update(customer);
    }

    @Override
    public Customer getByName(String name) {

        return this.getByName(name, null);
    }

    @Override
    @Cacheable(
            value = CacheRegion.CUSTOMER,
            key = "T(" + CUSTOMER_KEY + ").customerByName(#name)",
            condition = "#collectionsToInitialize == null")
    public Customer getByName(String name, AbstractDAO.CollectionName[] collectionsToInitialize) {

        return this.customerDAO.getUniqueLazyEntity(
                this.customerDAO.getCriteria().add(Restrictions.eq("name", name)),
                collectionsToInitialize);
    }

    @Override
    public Customer getByNameWithFavoriteVehicleTypes(String name) {

        return this.customerDAO.getUniqueLazyEntity(
                this.customerDAO.getCriteria().add(Restrictions.eq("name", name)),
                new AbstractDAO.CollectionName[]{Customer.Collection.FAVORITE_VEHICLE_TYPES});
    }

    @Override
    public Customer getByNameWithFavoriteVehicleTypes2(String name) {

        Customer customer = this.customerDAO.findUniqueByCriteria(Restrictions.eq("name", name));
        Hibernate.initialize(customer.getFavoritesVehicleTypes());
        return customer;
    }

    @Override
    public Customer getByIdFetchProfileInitialize(int id) {

        return this.customerDAO.getUniqueFetchEntity(id, "customer_sales");
    }

    @Override
    public List<Customer> getAll() {

        return this.customerDAO.findAll();
    }

    @Override
    public List<Customer> getAllByMinAgeFilter(int minAge) {
        this.customerDAO.getCurrentSession()
                .enableFilter("minAgeFilter")
                .setParameter("minAge", minAge);

        return getAll();
    }

    @Override
    public int getNumberOfSales(int id) {

        return this.customerDAO.getNumberOfSales(id);
    }

}