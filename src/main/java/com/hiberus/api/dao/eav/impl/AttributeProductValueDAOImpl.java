package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.AttributeProductValueDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.AttributeProductValue;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("attributeProductValueDAO")
public class AttributeProductValueDAOImpl extends AbstractDAOImpl<AttributeProductValue> implements AttributeProductValueDAO {

    protected AttributeProductValueDAOImpl() {
        super(AttributeProductValue.class);
    }

}
