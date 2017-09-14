package com.hiberus.practice.inheritance;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.model.inheritance1.Employee1;
import com.hiberus.api.model.inheritance1.Person1;
import com.hiberus.api.service.inheritance.Inheritance1Service;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by jorge on 28/06/2016.
 */
public class Inheritance1Test extends AppContextConfigurationAware {

    @Autowired
    private Inheritance1Service inheritance1Service;

    @Test
    public void getAllPersonTest() {
        List<Person1> person1List = this.inheritance1Service.getAllPerson();

        Assert.assertTrue(person1List != null);
    }

    @Test
    public void getAllEmployeeTest() {
        List<Employee1> employee1List = this.inheritance1Service.getAllEmployee();

        Assert.assertTrue(employee1List != null);
    }

}
