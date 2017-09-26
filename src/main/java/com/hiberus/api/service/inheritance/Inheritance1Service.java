package com.hiberus.api.service.inheritance;

import com.hiberus.api.model.inheritance1.Employee1;
import com.hiberus.api.model.inheritance1.Person1;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public interface Inheritance1Service {

    List<Person1> getAllPerson();

    List<Employee1> getAllEmployee();

    void insertEmployee(Employee1 employee1);

}
