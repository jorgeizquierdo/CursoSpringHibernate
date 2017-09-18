package com.hiberus.customer;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.model.factory.CustomerFactory;
import com.hiberus.api.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class CustomerTest extends AppContextConfigurationAware {

    @Autowired
    private CustomerService customerService;

    /**
     * Typical query.
     */
    //@Test
    public void getCustomers() {

        List<Customer> customerList = this.customerService.getAll();

        Assert.assertTrue(customerList != null);
    }

    /**
     * Sales collection is not initialized on transaction scope (inside service),
     * so, an LazyInitializationException is throwed when try to get it.
     */
    //@Test
    public void throwingLazyInitializationException() {

        try {

            this.customerService.getByName("Customer1").getSales().size();

            Assert.fail();
        } catch (Exception ex) {

            Assert.assertTrue(true);
        }
    }

    /**
     * Opposite the above method, sales collection is initialized on
     * transaction scope, so any operation performs good.
     */
    //@Test
    public void getWithoutLazyInitializationException() {

        this.customerService.getByName(
                "Customer1",
                new AbstractDAO.CollectionName[]{Customer.Collection.SALES})
                .getSales().size();
    }

    //@Test
    public void getWithFavoriteVehicleTypes() {

        Customer customer = this.customerService.getByNameWithFavoriteVehicleTypes("Customer1");
        Customer customer2 = this.customerService.getByNameWithFavoriteVehicleTypes2("Customer1");

        Assert.assertTrue(customer.getFavoritesVehicleTypes().size() != customer2.getFavoritesVehicleTypes().size());
    }

    /**
     * The same that above method but initialized by fetch prorfile
     */
    //@Test
    public void getWithoutLazyInitializationExceptionInitializeByFetchProfile() {

        this.customerService.getByIdFetchProfileInitialize(1).getSales().size();
    }

    /**
     * The same that above method but initialized by fetch prorfile
     */
    //@Test
    public void getCustomerFilterByMinAge() {

        this.customerService.getAllByMinAgeFilter(26);
    }

    /**
     * HQL is powerfull to handle querys.
     */
    //@Test
    public void getCustomerNumberOfSales(){

        Assert.assertTrue(this.customerService.getNumberOfSales(1) > 0);
    }

    /**
     * Inner calls don't take @Transactional annotation at runtime,
     * so all operations in the transaction are rollback.
     */
    //@Test
    public void savingCustomersWithInnerCalls() {

        Collection<Customer> customers = new ArrayList<>();

        int initialIdForName = 18;

        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer(null, 1, 25));

        try {

            this.customerService.saveCustomers(customers);
        } catch (Exception ex) {

            Assert.assertTrue(true);
            return;
        }

        Assert.fail();
    }

    //@Test
    public void savingCustomersWithOuterCalls() {

        Collection<Customer> customers = new ArrayList<>();

        int initialIdForName = 18;

        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer("Customer" + initialIdForName++, 1, 25));
        customers.add(CustomerFactory.newCustomer(null, 1, 25));

        this.customerService.saveCustomersWithWorkAround(customers);
    }

    /**
     * Test to check the Spring cache abstraction.
     */
    //@Test
    public void testingCaches(){

        this.customerService.getByName("Customer1", null);
        this.customerService.getByName("Customer1", null);
    }

    /**
     * Test to check the Spring cache abstraction limitations throught inner calls.
     */
    //@Test
    public void testingCachesWithInnerCall(){

        this.customerService.getByName("Customer1");
        this.customerService.getByName("Customer1");
    }

    //@Test
    public void fetchingCustomerFromRest() throws Exception {

        super.mockMvc.perform(
                get("/rest/customer/get/Customer1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //@Test
    public void fetchingCustomerWithSalesFromRest() throws Exception {

        super.mockMvc.perform(
                get("/rest/customer/get/Customer1/true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //@Test
    public void fetchingAllCustomersFromRest() throws Exception {

        super.mockMvc.perform(
                get("/rest/customer/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //@Test
    public void fetchingAllCustomersFromRestSecured() throws Exception {

        super.mockMvc.perform(
                get("/rest/customer/all/secured")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andDo(print());
    }

    //@Test
    public void fetchingAllCustomersFromRestSecuredWithAuthorization() throws Exception {

        String authorization = "Basic " + new String(Base64.encode(("user:password").getBytes()));

        super.mockMvc.perform(
                get("/rest/customer/all/secured")
                        .header(HttpHeaders.AUTHORIZATION, authorization)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void dummyTest() {
        Assert.assertTrue(true);
    }

}