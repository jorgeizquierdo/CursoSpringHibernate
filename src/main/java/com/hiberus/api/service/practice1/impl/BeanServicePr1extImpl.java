package com.hiberus.api.service.practice1.impl;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class BeanServicePr1extImpl extends BeanServicePr1Impl {

    public BeanServicePr1extImpl() {
        System.out.println("BeanServicePr1extImpl constructed!");
    }

    @Override
    public void init() {

    }

    @Override
    public String sayHello() {
        return "Hello1ext";
    }

}
