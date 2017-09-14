package com.hiberus.api.service.inheritance.impl;

import com.hiberus.api.dao.inheritance2.Employee2DAO;
import com.hiberus.api.dao.inheritance2.Owner2DAO;
import com.hiberus.api.dao.inheritance2.Person2DAO;
import com.hiberus.api.dao.inheritance3.Employee3DAO;
import com.hiberus.api.dao.inheritance3.Owner3DAO;
import com.hiberus.api.dao.inheritance3.Person3DAO;
import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.model.inheritance3.Employee3;
import com.hiberus.api.model.inheritance3.Owner3;
import com.hiberus.api.model.inheritance3.Person3;
import com.hiberus.api.service.inheritance.Inheritance2Service;
import com.hiberus.api.service.inheritance.Inheritance3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
@Service("inheritance3Service")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class Inheritance3ServiceImpl implements Inheritance3Service {

    @Autowired
    private Person3DAO person3DAO;
    @Autowired
    private Employee3DAO employee3DAO;
    @Autowired
    private Owner3DAO owner3DAO;

    @Override
    public List<Person3> getAllPerson() {
        return this.person3DAO.findAll();
    }

    @Override
    public List<Employee3> getAllEmployee() {
        return this.employee3DAO.findAll();
    }

    @Override
    public List<Owner3> getAllOwner() {
        return this.owner3DAO.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertOwner(Owner3 owner) {
        this.owner3DAO.save(owner);
    }

}
