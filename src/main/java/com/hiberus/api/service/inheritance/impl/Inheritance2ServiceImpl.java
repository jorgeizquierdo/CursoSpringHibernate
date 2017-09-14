package com.hiberus.api.service.inheritance.impl;

import com.hiberus.api.dao.inheritance2.Employee2DAO;
import com.hiberus.api.dao.inheritance2.Owner2DAO;
import com.hiberus.api.dao.inheritance2.Person2DAO;
import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.service.inheritance.Inheritance2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
@Service("inheritance2Service")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class Inheritance2ServiceImpl implements Inheritance2Service {

    @Autowired
    private Person2DAO person2DAO;
    @Autowired
    private Employee2DAO employee2DAO;
    @Autowired
    private Owner2DAO owner2DAO;

    @Override
    public List<Person2> getAllPerson() {
        return this.person2DAO.findAll();
    }

    @Override
    public List<Employee2> getAllEmployee() {
        return this.employee2DAO.findAll();
    }

    @Override
    public List<Owner2> getAllOwner() {
        return this.owner2DAO.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertOwner(Owner2 owner) {
        this.owner2DAO.save(owner);
    }

}
