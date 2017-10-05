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
        this.productDAO.getCurrentSession()
                .enableFilter("maxStock")
                .setParameter("maxStock", maxStock);
        return this.productDAO.findAll();
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
        return this.productDAO.getCriteria()
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .createAlias("attributeProductValueList", "apv")
                    .createAlias("apv.eavAttribute", "attr")
                        .add(Restrictions.in("attr.eavAttributeGroup.id", new Integer[]{1, 2}))
                .list();
    }

    @Override
    public List<Product> query2Criteria() {
        // Productos que no tengan atributos del tipo con codigo 'attribute_type_3'
        return this.productDAO.getCriteria()
                .add(Subqueries.propertyNotIn("id", DetachedCriteria.forClass(AttributeProductValue.class)
                    .setProjection(Projections.distinct(Projections.property("product.id")))
                    .createAlias("eavAttribute", "attr")
                        .createAlias("attr.eavAttributeType", "type")
                            .add(Restrictions.like("type.code", "attribute_type_3"))))
                .list();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Product> query1HQL() {
        // Productos que tengan atributos de los grupos 1 y 2
        String hql =
                "SELECT distinct p " +
                        "FROM product p " +
                        "INNER JOIN p.attributeProductValueList apv " +
                        "INNER JOIN apv.eavAttribute attr " +
                        "INNER JOIN attr.eavAttributeGroup grp " +
                        "WHERE grp.id IN (:ids) ";
        return  this.productDAO.getCurrentSession().createQuery(hql).setParameterList("ids", new Integer[]{1, 2}).list();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Product> query2HQL() {
        // Productos que no tengan atributos del tipo 3
        String hql =
                "SELECT p " +
                        "FROM product p " +
                        "WHERE p.id NOT IN (SELECT distinct apv.product.id " +
                        "FROM attributeProductValue apv " +
                        "INNER JOIN apv.eavAttribute attr " +
                        "INNER JOIN attr.eavAttributeType type " +
                        "WHERE type.code = :code)";
        return  this.productDAO.getCurrentSession().createQuery(hql).setParameter("code", "attribute_type_3").list();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertAttributeProductValue(int attributeId, int productId, String value) {
        EavAttribute eavAttribute = this.eavAttributeDAO.findById(attributeId);
        Product product = this.productDAO.findById(productId);

        if (eavAttribute != null && product != null) {
            AttributeProductValue attributeProductValue = new AttributeProductValue();
            attributeProductValue.setEavAttribute(eavAttribute);
            attributeProductValue.setProduct(product);
            attributeProductValue.setValue(value);

            this.attributeProductValueDAO.saveOrUpdate(attributeProductValue);
        }
    }

}
