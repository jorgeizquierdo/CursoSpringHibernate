package com.hiberus.api.service.impl;

import com.hiberus.api.dao.SaleDAO;
import com.hiberus.api.model.factory.SaleFactory;
import com.hiberus.api.model.sale.Sale;
import com.hiberus.api.service.SaleService;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Service(value = "saleService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Sale saveSale(Sale sale) {

        // Sale is a "new" state object until be marked to be "persisted".
        sale.setId(this.saleDAO.save(sale));

        // Right here, sale is marked to be "persisted", so it's "managed" by the
        // persistent context until get out the transaction method and spring-orm closes it.

        // When transaction is closed, sale is marked as "detached", and the persistent
        // context won't know any operation performed on it.
        return sale;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void updateSalePurchaseDate(int saleId, Date date) {

        // Sale is a "new" state object until be marked to be "persisted".
        Sale sale = (Sale) this.saleDAO.getCriteria()
                .add(Restrictions.eq("id", saleId))
                .setMaxResults(1)
                .uniqueResult();

        // Right here, sale is "managed" by the persistent context,
        // so, persistent context is aware of any change.
        sale.setPurchaseDate(date);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void updateDuplicateSalePurchaseDate(int saleId, Date date) {

        // Sale is a "new" state object until be marked to be "persisted".
        Sale sale = (Sale) this.saleDAO.getCriteria()
                .add(Restrictions.eq("id", saleId))
                .setMaxResults(1)
                .uniqueResult();

        // Inside the same transaction, another object, with same type (entity) and
        // id is created.
        Sale newSale = SaleFactory.newSale(sale.getCustomer(), sale.getVehicle());
        newSale.setId(saleId);

        // ... and it's marked as "update (so managed)", throwing an NonUniqueObjectException.
        this.saleDAO.update(newSale);
    }

    @Override
    public Sale getNewSaleByVehicleIdCustomerIdWithHQL(int vehicleId, int customerId) {
        String query =
                "select new com.hiberus.api.model.sale.Sale(v, c) " +
                "from vehicle v, customer c " +
                "where " +
                "   v.id = ? and " +
                "   c.id = ?";
        List params = new ArrayList();
        params.add(vehicleId);
        params.add(customerId);
        return this.saleDAO.findUniqueByHQL(query, params);
    }

}