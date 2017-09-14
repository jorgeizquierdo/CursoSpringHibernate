package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.ProductDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("productDAO")
public class ProductDAOImpl extends AbstractDAOImpl<Product> implements ProductDAO {

    protected ProductDAOImpl() {
        super(Product.class);
    }

}
