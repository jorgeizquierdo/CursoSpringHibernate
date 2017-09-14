package com.hiberus.api.dao.inheritance2.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance2.Employee2DAO;
import com.hiberus.api.model.inheritance1.Employee1;
import com.hiberus.api.model.inheritance2.Employee2;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("employee2DAO")
public class Employee2DAOImpl extends AbstractDAOImpl<Employee2> implements Employee2DAO {

    protected Employee2DAOImpl() {
        super(Employee2.class);
    }

}
