package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.EavAttributeDAO;
import com.hiberus.api.dao.eav.EavAttributeGroupDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.EavAttribute;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("eavAttributeDAO")
public class EavAttributeDAOImpl extends AbstractDAOImpl<EavAttribute> implements EavAttributeDAO {

    protected EavAttributeDAOImpl() {
        super(EavAttribute.class);
    }

}
