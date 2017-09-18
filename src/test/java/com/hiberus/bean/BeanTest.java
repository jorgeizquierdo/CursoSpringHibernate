package com.hiberus.bean;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.service.BeanService;
import com.hiberus.api.service.practice1.BeanServicePr1;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

public class BeanTest extends AppContextConfigurationAware {

    @Autowired
    @Qualifier("beanServicePr1Impl")
    private BeanServicePr1 beanService;

    @Test
    public void contextInitializacion() {
        Assert.assertTrue(true);
    }

    @Test
    public void sayHello() {
        Assert.assertTrue(this.beanService.sayHello().equals("Hello1"));
    }

    @Test
    public void sayHelloFromContext() {
        Assert.assertTrue(
                super.webApplicationContext.getBean(BeanServicePr1.class)
                        .sayHello().equals("Hello1"));
    }

}