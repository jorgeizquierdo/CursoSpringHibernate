package com.hiberus.api.dao.inheritance3.impl;

import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.dao.inheritance3.Owner3DAO;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance3.Owner3;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 28/06/2016.
 */
@Repository("owner3DAO")
public class Owner3DAOImpl extends AbstractDAOImpl<Owner3> implements Owner3DAO {

    protected Owner3DAOImpl() {
        super(Owner3.class);
    }

}
