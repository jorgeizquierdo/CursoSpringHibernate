package com.hiberus.api.dao.impl;

import com.hiberus.api.dao.SaleDAO;
import com.hiberus.api.model.sale.Sale;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Repository(value = "saleDAO")
public class SaleDAOImpl extends AbstractDAOImpl<Sale> implements SaleDAO {

    protected SaleDAOImpl() {

        super(Sale.class);
    }

}