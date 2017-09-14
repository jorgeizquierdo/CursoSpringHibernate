package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.EavAttributeGroupDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.EavAttributeGroup;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("eavAttributeGroupDAO")
public class EavAttributeGroupDAOImpl extends AbstractDAOImpl<EavAttributeGroup> implements EavAttributeGroupDAO {

    protected EavAttributeGroupDAOImpl() {
        super(EavAttributeGroup.class);
    }

}
