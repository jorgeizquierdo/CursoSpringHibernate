package com.hiberus.api.service.inheritance;

import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public interface Inheritance2Service {

    List<Person2> getAllPerson();

    List<Employee2> getAllEmployee();

    List<Owner2> getAllOwner();

    void insertOwner(Owner2 owner);

}
