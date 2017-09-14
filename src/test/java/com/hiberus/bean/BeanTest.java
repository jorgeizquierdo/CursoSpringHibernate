package com.hiberus.bean;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.service.BeanService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

/**
 * Created by Daniel on 14/06/2016.
 */
public class BeanTest extends AppContextConfigurationAware {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    @Qualifier("beanServiceOne")
    private BeanService beanService;

    @Test
    public void contextInitializacion() {

        Assert.assertTrue(true);
    }

    @Test
    public void sayHello() {

        Assert.assertTrue(this.beanService.sayHello().equals("Hello"));
    }

    @Test
    public void sayHelloFromContext() {

        Assert.assertTrue(
                super.webApplicationContext.getBean(BeanService.class)
                        .sayHello().equals("Hello"));
    }

}