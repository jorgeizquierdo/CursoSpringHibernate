package com.hiberus.api.service.inheritance.impl;

import com.hiberus.api.dao.inheritance1.Employee1DAO;
import com.hiberus.api.dao.inheritance1.Person1DAO;
import com.hiberus.api.model.inheritance1.Employee1;
import com.hiberus.api.model.inheritance1.Person1;
import com.hiberus.api.service.inheritance.Inheritance1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
@Service("inheritance1Service")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class Inheritance1ServiceImpl implements Inheritance1Service {

    @Autowired
    private Person1DAO person1DAO;
    @Autowired
    private Employee1DAO employee1DAO;

    @Override
    public List<Person1> getAllPerson() {
        return this.person1DAO.findAll();
    }

    @Override
    public List<Employee1> getAllEmployee() {
        return this.employee1DAO.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void insertEmployee(Employee1 employee1) {
        this.employee1DAO.save(employee1);
    }

}
