package com.hiberus.practice.inheritance;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.model.inheritance1.Employee1;
import com.hiberus.api.model.inheritance1.Person1;
import com.hiberus.api.model.inheritance2.Employee2;
import com.hiberus.api.model.inheritance2.Owner2;
import com.hiberus.api.model.inheritance2.Person2;
import com.hiberus.api.service.inheritance.Inheritance1Service;
import com.hiberus.api.service.inheritance.Inheritance2Service;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public class Inheritance2Test extends AppContextConfigurationAware {

    @Autowired
    private Inheritance2Service inheritance2Service;

    @Test
    public void getAllPersonTest() {
        List<Person2> person2List = this.inheritance2Service.getAllPerson();

        Assert.assertTrue(person2List != null);
    }

    @Test
    public void getAllEmployeeTest() {
        List<Employee2> employee2List = this.inheritance2Service.getAllEmployee();

        Assert.assertTrue(employee2List != null);
    }

    @Test
    public void getAllOwnerTest() {
        List<Owner2> owner2List = this.inheritance2Service.getAllOwner();

        Assert.assertTrue(owner2List != null);
    }

    @Test
    public void insertOwnerTest() {
        this.inheritance2Service.insertOwner(new Owner2("firstname owner 3", "lastname owner 3", 888L, 999L));
    }

}
