package com.hiberus.api.dao.impl;

import com.hiberus.api.dao.CustomerDAO;
import com.hiberus.api.model.customer.Customer;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Repository("customerDAO")
public class CustomerDAOImpl extends AbstractDAOImpl<Customer> implements CustomerDAO {

    protected CustomerDAOImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> greaterThan(int age) {

        return super.getCriteria().add(Restrictions.gt("age", age)).list();
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public int getNumberOfSales(int id) {

        String hql =
                "SELECT COUNT(s) FROM customer AS c " +
                        "INNER JOIN c.sales AS s " +
                        "WHERE c.id = :id";

        Query query = super.getCurrentSession().createQuery(hql);
        query.setInteger("id", id);

        return ((Long) query.uniqueResult()).intValue();
    }

}