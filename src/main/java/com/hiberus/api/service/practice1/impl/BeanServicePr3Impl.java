package com.hiberus.api.service.practice1.impl;

import com.hiberus.api.service.practice1.BeanServicePr1;
import com.hiberus.api.service.practice1.BeanServicePr3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BeanServicePr3Impl implements BeanServicePr3 {

    @Autowired
    BeanServicePr1 beanServicePr1;

    public BeanServicePr3Impl() {
        System.out.println("BeanServicePr3Impl constructed!");
    }

    @Override
    public void init() {

    }

    @Override
    public String sayHello() {
        return "Hello3";
    }

}
