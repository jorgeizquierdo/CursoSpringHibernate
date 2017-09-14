package com.hiberus.api.dao.inheritance2.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance2.Person2DAO;
import com.hiberus.api.model.inheritance1.Person1;
import com.hiberus.api.model.inheritance2.Person2;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("person2DAO")
public class Person2DAOImpl extends AbstractDAOImpl<Person2> implements Person2DAO {

    protected Person2DAOImpl() {
        super(Person2.class);
    }

}
