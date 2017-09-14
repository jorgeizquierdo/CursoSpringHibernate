package com.hiberus.api.dao.inheritance1.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance1.Person1DAO;
import com.hiberus.api.model.inheritance1.Person1;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("person1DAO")
public class Person1DAOImpl extends AbstractDAOImpl<Person1> implements Person1DAO {

    protected Person1DAOImpl() {
        super(Person1.class);
    }

}
