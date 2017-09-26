package com.hiberus.api.service.inheritance;

import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.model.inheritance3.Employee3;
import com.hiberus.api.model.inheritance3.Owner3;
import com.hiberus.api.model.inheritance3.Person3;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public interface Inheritance3Service {

    List<Person3> getAllPerson();

    List<Employee3> getAllEmployee();

    List<Owner3> getAllOwner();

}
