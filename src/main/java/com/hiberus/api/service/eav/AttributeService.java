package com.hiberus.api.service.eav;

import com.hiberus.api.model.eav.EavAttribute;
import com.hiberus.api.model.eav.EavAttributeGroup;
import com.hiberus.api.model.eav.EavAttributeGroupExtended;
import com.hiberus.api.model.eav.EavAttributeType;

import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
public interface AttributeService {

    List<EavAttribute> getAllAttributes();

    List<EavAttributeType> getAllAttributeTypes();

    List<EavAttributeGroup> getAllAttributeGroups();

    void insertAttributeGroup(EavAttributeGroup eavAttributeGroup);

    List<EavAttributeGroupExtended> getAllFullAttributeGroups();

    void insertAttributeGroup(EavAttributeGroupExtended eavAttributeGroup);

    EavAttribute getAttributeById(int id);

    EavAttributeType getAttributeTypeById(int id);

    EavAttributeGroup getAttributeGroupById(int id);

    EavAttributeType getAttributeTypeByIdFetchProfileInitialize1(int id);

    EavAttributeType getAttributeTypeByIdFetchProfileInitialize2(int id);

    EavAttributeType getAttributeTypeByIdCriteriaInitialize1(int id);

    EavAttributeType getAttributeTypeByIdCriteriaInitialize2(int id);

    EavAttributeType getAttributeTypeByIdHibernateInitialize(int id);

    void insertAttributeType(String name);

}
