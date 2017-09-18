package com.hiberus.practice.inheritance;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.model.inheritance3.Employee3;
import com.hiberus.api.model.inheritance3.Owner3;
import com.hiberus.api.model.inheritance3.Person3;
import com.hiberus.api.service.inheritance.Inheritance2Service;
import com.hiberus.api.service.inheritance.Inheritance3Service;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public class Inheritance3Test extends AppContextConfigurationAware {

    @Autowired
    private Inheritance3Service inheritance3Service;

    //@Test
    public void getAllPersonTest() {
        List<Person3> person3List = this.inheritance3Service.getAllPerson();

        Assert.assertTrue(person3List != null);
    }

    //@Test
    public void getAllEmployeeTest() {
        List<Employee3> employee3List = this.inheritance3Service.getAllEmployee();

        Assert.assertTrue(employee3List != null);
    }

    //@Test
    public void getAllOwnerTest() {
        List<Owner3> owner3List = this.inheritance3Service.getAllOwner();

        Assert.assertTrue(owner3List != null);
    }

    //@Test
    public void insertOwnerTest() {
        this.inheritance3Service.insertOwner(new Owner3("firstname owner 2", "lastname owner 2", 888L, 999L));
    }

    @Test
    public void dummyTest() {
        Assert.assertTrue(true);
    }

}
