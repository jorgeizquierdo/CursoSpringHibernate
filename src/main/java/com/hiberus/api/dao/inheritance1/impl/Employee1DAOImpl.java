package com.hiberus.api.dao.inheritance1.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance1.Employee1DAO;
import com.hiberus.api.model.inheritance1.Employee1;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("employee1DAO")
public class Employee1DAOImpl extends AbstractDAOImpl<Employee1> implements Employee1DAO {

    protected Employee1DAOImpl() {
        super(Employee1.class);
    }

}
