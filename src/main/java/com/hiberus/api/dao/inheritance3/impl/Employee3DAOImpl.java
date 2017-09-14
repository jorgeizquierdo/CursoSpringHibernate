package com.hiberus.api.dao.inheritance3.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance3.Employee3DAO;
import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance3.Employee3;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("employee3DAO")
public class Employee3DAOImpl extends AbstractDAOImpl<Employee3> implements Employee3DAO {

    protected Employee3DAOImpl() {
        super(Employee3.class);
    }

}
