package com.hiberus.api.service;

import com.hiberus.api.model.sale.Sale;

import java.util.Date;

/**
 * Created by Daniel Pardo Ligorred.
 */
public interface SaleService {

    Sale saveSale(Sale sale);

    void updateSalePurchaseDate(int saleId, Date date);

    void updateDuplicateSalePurchaseDate(int saleId, Date date);

    Sale getNewSaleByVehicleIdCustomerIdWithHQL(int vehicleId, int customerId);

}