package com.hiberus.api.service.practice1.impl;

import com.hiberus.api.service.practice1.BeanServicePr1;
import com.hiberus.api.service.practice1.BeanServicePr2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BeanServicePr2Impl implements BeanServicePr2 {

    @Autowired
    BeanServicePr1 beanServicePr1;

    public BeanServicePr2Impl() {
        System.out.println("BeanServicePr2Impl constructed!");
    }

    @Override
    public void init() {

    }

    @Override
    public String sayHello() {
        return "Hello2";
    }

}
