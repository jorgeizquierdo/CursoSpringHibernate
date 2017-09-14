package com.hiberus.api.dao.inheritance3.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance3.Person3DAO;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.model.inheritance3.Person3;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("person3DAO")
public class Person3DAOImpl extends AbstractDAOImpl<Person3> implements Person3DAO {

    protected Person3DAOImpl() {
        super(Person3.class);
    }

}
