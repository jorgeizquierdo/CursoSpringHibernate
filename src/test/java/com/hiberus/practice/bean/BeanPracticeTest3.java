package com.hiberus.practice.bean;

import com.hiberus.api.service.BeanService;
import com.hiberus.api.service.PracticeBean;
import com.hiberus.api.service.impl.practice.BeanServiceOne;
import com.hiberus.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Daniel on 15/06/2016.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BeanPracticeTest3 {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private PracticeBean practiceBean;

    /**
     * Modificando unicamente el metodo practiceBean.doSomething()
     * hacer que este test funcione.
     */
    @Test
    public void sayHello2() {

        String prevHello = ((BeanService) this.applicationContext.getBean("beanServiceOne")).sayHello();

        this.practiceBean.doSomething();

        Assert.assertTrue(!((BeanService) this.applicationContext.getBean("beanServiceOne")).sayHello().equals(prevHello));
    }

}