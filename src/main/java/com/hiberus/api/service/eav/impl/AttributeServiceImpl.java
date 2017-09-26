package com.hiberus.api.service.eav.impl;

import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.dao.eav.EavAttributeDAO;
import com.hiberus.api.dao.eav.EavAttributeGroupDAO;
import com.hiberus.api.dao.eav.EavAttributeGroupExtendedDAO;
import com.hiberus.api.dao.eav.EavAttributeTypeDAO;
import com.hiberus.api.model.eav.*;
import com.hiberus.api.service.eav.AttributeService;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Service("attributeService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private EavAttributeDAO eavAttributeDAO;
    @Autowired
    private EavAttributeTypeDAO eavAttributeTypeDAO;
    @Autowired
    private EavAttributeGroupDAO eavAttributeGroupDAO;
    @Autowired
    private EavAttributeGroupExtendedDAO eavAttributeGroupExtendedDAO;

    @Override
    public EavAttribute getAttributeById(int id) {
        return this.eavAttributeDAO.findById(id);
    }

    @Override
    public List<EavAttribute> getAllAttributes() {
        return this.eavAttributeDAO.findAll();
    }

    @Override
    public EavAttributeType getAttributeTypeById(int id) {
        return this.eavAttributeTypeDAO.findById(id);
    }

    @Override
    public List<EavAttributeType> getAllAttributeTypes() {
        return this.eavAttributeTypeDAO.findAll();
    }

    @Override
    public EavAttributeGroup getAttributeGroupById(int id) {
        return this.eavAttributeGroupDAO.findById(id);
    }

    @Override
    public List<EavAttributeGroup> getAllAttributeGroups() {
        return this.eavAttributeGroupDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertAttributeGroup(EavAttributeGroup eavAttributeGroup) {
        this.eavAttributeGroupDAO.save(eavAttributeGroup);
    }

    @Override
    public List<EavAttributeGroupExtended> getAllFullAttributeGroups() {
        return this.eavAttributeGroupExtendedDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertAttributeGroup(EavAttributeGroupExtended eavAttributeGroup) {
        this.eavAttributeGroupExtendedDAO.save(eavAttributeGroup);
    }

    @Override
    public EavAttributeType getAttributeTypeByIdFetchProfileInitialize1(int id) {
        // Usando un metodo de AbstractDAO
        return null;
    }

    @Override
    public EavAttributeType getAttributeTypeByIdFetchProfileInitialize2(int id) {
        // Habilitando el filtro desde la session
        return null;
    }

    @Override
    public EavAttributeType getAttributeTypeByIdCriteriaInitialize1(int id) {
        // Usando un metodo de AbstractDAO
        return null;
    }

    @Override
    public EavAttributeType getAttributeTypeByIdCriteriaInitialize2(int id) {
        // Usando Criteria
        return null;
    }

    @Override
    public EavAttributeType getAttributeTypeByIdHibernateInitialize(int id) {
        // Usando Hibernate.initialize
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertAttributeType(String name) {
        EavAttributeType eavAttributeType = new EavAttributeType();
        eavAttributeType.setName(name);
        eavAttributeType.setCode(name.toLowerCase().replaceAll("\\s+", "_"));
        this.eavAttributeTypeDAO.save(eavAttributeType);
    }

}
