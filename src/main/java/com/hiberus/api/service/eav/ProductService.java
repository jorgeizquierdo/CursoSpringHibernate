package com.hiberus.api.service.eav;

import com.hiberus.api.model.eav.AttributeProductValue;
import com.hiberus.api.model.eav.Product;

import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
public interface ProductService {

    Product getProductById(int id);

    List<Product> getAllProducts();

    List<AttributeProductValue> getAllAttributeProductValues();

    Product getProductByIdFetchProfileInitialize(int id);

    Product getProductByIdCriteriaInitialize(int id);

    Product getProductByIdHibernateInitialize(int id);

    List<Product> getAllFilteredByMaxStock(int maxStock);

    Integer numberOfProducts();

    List<Product> getByAttr1Value(String attr);

    List<Product> query1Criteria();

    List<Product> query2Criteria();

    List<Product> query1HQL();

    List<Product> query2HQL();

    void insertAttributeProductValue(int attributeId, int productId, String value);

}
