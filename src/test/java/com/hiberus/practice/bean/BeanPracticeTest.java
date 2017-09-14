package com.hiberus.practice.bean;

import com.hiberus.api.service.BeanService;
import com.hiberus.api.service.impl.practice.BeanServiceOne;
import com.hiberus.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Daniel on 15/06/2016.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BeanPracticeTest {

    // Practice purposes only.
    @Autowired
    private BeanServiceOne beanService;

    /**
     * Sin modificar este metodo, ni ningun otro bean actual, hacer que
     * este test funcione.
     */
    @Test
    public void sayHello2() {

        Assert.assertTrue(this.beanService.sayHello().equals("HelloPractice"));
    }

}