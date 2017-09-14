package com.hiberus.sale;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.customer.Customer;
import com.hiberus.api.model.factory.SaleFactory;
import com.hiberus.api.model.sale.Sale;
import com.hiberus.api.model.vehicle.Vehicle;
import com.hiberus.api.service.CustomerService;
import com.hiberus.api.service.SaleService;
import com.hiberus.api.service.VehicleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daniel Pardo Ligorred.
 */
public class SaleTest extends AppContextConfigurationAware {

    @Autowired
    private SaleService saleService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private VehicleService vehicleService;

    @Test
    public void persistSale(){

        // Detached object, just when transaction ends.
        Customer customer = this.customerService.getByName("Customer1");
        // Detached object, just when transaction ends.
        Vehicle vehicle = this.vehicleService.getByName("Car1");

        Sale sale = SaleFactory.newSale(customer, vehicle);

        this.saleService.saveSale(sale);

        Assert.assertTrue(sale.getId() != 0);
    }

    /**
     * With @Cascade(CascadeType.SAVE_UPDATE) on Customer.sales
     */
    @Test
    public void persistSaleFromCustomer() {

        // Detached object, just when transaction ends.
        Customer customer = this.customerService.getByName("Customer1");
        // Detached object, just when transaction ends.
        Vehicle vehicle = this.vehicleService.getByName("Truck1");

        Set<Sale> sales = new HashSet<>();

        sales.add(SaleFactory.newSale(customer, vehicle));

        customer.setSales(sales);

        this.customerService.updateCustomer(customer);
    }

    /**
     * With @Cascade(CascadeType.SAVE_UPDATE) on Customer.sales
     */
    @Test
    public void updateSaleFromCustomer(){

        // Detached object (as its children collections), just when transaction ends.
        Customer customer = this.customerService.getByName("Customer1", new AbstractDAO.CollectionName[]{Customer.Collection.SALES});

        // Sale, as your parent (Customer), are detached, but both are filled
        // with the persisted ID (so we can "merge" them after).
        Sale sale = customer.getSales().iterator().next();

        sale.setPurchaseDate(new Date());

        // How is detached from the persistent context,
        // we must update it throught the Customer parent entity.
        // Therefore, in the update method from CustomerDAO, Customer (and all its children collection)
        // will be "merged" in the persistent context again like "managed" object marked to
        // be update.
        this.customerService.updateCustomer(customer);
    }

    @Test
    public void updateSalePurchaseDate(){

        this.saleService.updateSalePurchaseDate(4, new Date());
    }

    @Test
    public void throwingNonUniqueObjectException(){

        this.saleService.updateDuplicateSalePurchaseDate(4, new Date());
    }

    @Test
    public void newSaleByVehicleIdCustomerIdWithHQL(){

        Sale sale = this.saleService.getNewSaleByVehicleIdCustomerIdWithHQL(1, 8);

        Assert.assertTrue(sale != null);
    }

}