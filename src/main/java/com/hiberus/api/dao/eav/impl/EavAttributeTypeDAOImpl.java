package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.EavAttributeTypeDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.EavAttributeType;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("eavAttributeTypeDAO")
public class EavAttributeTypeDAOImpl extends AbstractDAOImpl<EavAttributeType> implements EavAttributeTypeDAO {

    protected EavAttributeTypeDAOImpl() {
        super(EavAttributeType.class);
    }

}
