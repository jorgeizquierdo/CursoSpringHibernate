package com.hiberus.practice.bean;

import com.hiberus.api.service.PracticeBean;
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
public class BeanPracticeTest2 {

    @Autowired
    private PracticeBean practiceBean;

    /**
     * Modificando unicamente el metodo practiceBean.randomHello()
     * hacer que este test funcione.
     */
    @Test
    public void randomHello() {

        for (int ntry = 0; ntry < 20; ntry++) {

            boolean result = !this.practiceBean.randomHello().equals(this.practiceBean.randomHello());

            if (result) return;
        }

        Assert.fail();
    }

}