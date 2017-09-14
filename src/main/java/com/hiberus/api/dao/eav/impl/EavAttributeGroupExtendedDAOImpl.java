package com.hiberus.api.dao.eav.impl;

import com.hiberus.api.dao.eav.EavAttributeGroupDAO;
import com.hiberus.api.dao.eav.EavAttributeGroupExtendedDAO;
import com.hiberus.api.dao.impl.AbstractDAOImpl;
import com.hiberus.api.model.eav.EavAttributeGroup;
import com.hiberus.api.model.eav.EavAttributeGroupExtended;
import org.springframework.stereotype.Repository;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Repository("eavAttributeGroupExtendedDAO")
public class EavAttributeGroupExtendedDAOImpl extends AbstractDAOImpl<EavAttributeGroupExtended> implements EavAttributeGroupExtendedDAO {

    protected EavAttributeGroupExtendedDAOImpl() {
        super(EavAttributeGroupExtended.class);
    }

}
