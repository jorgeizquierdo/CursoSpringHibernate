package com.hiberus.api.dao.inheritance2.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance2.Owner2DAO;
import com.hiberus.api.dao.inheritance2.Person2DAO;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("owner2DAO")
public class Owner2DAOImpl extends AbstractDAOImpl<Owner2> implements Owner2DAO {

    protected Owner2DAOImpl() {
        super(Owner2.class);
    }

}
