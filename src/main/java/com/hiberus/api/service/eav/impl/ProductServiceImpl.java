package com.hiberus.api.service.eav.impl;

import com.hiberus.api.dao.eav.AttributeProductValueDAO;
import com.hiberus.api.dao.eav.EavAttributeDAO;
import com.hiberus.api.dao.eav.ProductDAO;
import com.hiberus.api.model.eav.AttributeProductValue;
import com.hiberus.api.model.eav.EavAttribute;
import com.hiberus.api.model.eav.Product;
import com.hiberus.api.service.eav.ProductService;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Service("productService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private AttributeProductValueDAO attributeProductValueDAO;
    @Autowired
    private EavAttributeDAO eavAttributeDAO;

    @Override
    public Product getProductById(int id) {
        return this.productDAO.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.findAll();
    }

    @Override
    public List<AttributeProductValue> getAllAttributeProductValues() {
        return this.attributeProductValueDAO.findAll();
    }

    @Override
    public Product getProductByIdFetchProfileInitialize(int id) {
        this.productDAO.getCurrentSession().enableFetchProfile("attribute_product_value");
        return this.productDAO.findById(id);
    }

    @Override
    public Product getProductByIdCriteriaInitialize(int id) {
        return (Product) this.productDAO.getCriteria()
                .add(Restrictions.idEq(id))
                .setFetchMode(Product.Collection.ATTRIBUTE_VALUES_MAP.getCollectionName(), FetchMode.JOIN)
                .uniqueResult();
    }

    @Override
    public Product getProductByIdHibernateInitialize(int id) {
        Product product = this.productDAO.findById(id);
        Hibernate.initialize(product.getAttributeValuesMap());
        return product;
    }

    @Override
    public List<Product> getAllFilteredByMaxStock(int maxStock) {
        // Definir filtro en la entidad producto que filtre por stock maximo y usarlo aqui
        return null;
    }

    @Override
    public Integer numberOfProducts() {
        return ((Long) this.productDAO.getCriteria().setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    @Override
    public List<Product> getByAttr1Value(String attr) {
        // Productos cuyo atributo 1 contenga el valor {attr}
        return this.productDAO.getCriteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .createAlias("attributeProductValueList", "apv", JoinType.LEFT_OUTER_JOIN)
                    .add(Restrictions.eq("apv.eavAttribute.id", 1))
                    .add(Restrictions.like("apv.value", "%" + attr + "%"))
                .list();
        /*return this.productDAO.getCriteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Subqueries.propertyIn("id", DetachedCriteria.forClass(AttributeProductValue.class)
                    .add(Restrictions.like("value", "%" + attr + "%"))
                    .setProjection(Projections.distinct(Projections.property("product")))))
                .list();*/
    }

    @Override
    public List<Product> query1Criteria() {
        // Productos que tengan atributos de los grupos 1 y 2
        return new ArrayList<>();
    }

    @Override
    public List<Product> query2Criteria() {
        // Productos que no tengan atributos del tipo con codigo 'attribute_type_3'
        return new ArrayList<>();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Product> query1HQL() {
        // Productos que tengan atributos de los grupos 1 y 2
        return new ArrayList<>();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Product> query2HQL() {
        // Productos que no tengan atributos del tipo 3
        return new ArrayList<>();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertAttributeProductValue(int attributeId, int productId, String value) {
        // Insertar valor para un atributo, o actualizarlo si ya tiene un valor
    }

}
