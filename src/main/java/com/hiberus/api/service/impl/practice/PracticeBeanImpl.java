package com.hiberus.api.service.impl.practice;

import com.hiberus.api.service.PracticeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Daniel on 16/06/2016.
 */
//@Component
public class PracticeBeanImpl implements PracticeBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String randomHello() {

        return "HelloDefault";
    }

    @Override
    public void doSomething() {

    }

    private int randomFromZeroToMax(int max) {

        return new Random().nextInt(max);
    }

}