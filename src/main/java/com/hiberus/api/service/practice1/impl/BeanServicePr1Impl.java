package com.hiberus.api.service.practice1.impl;

import com.hiberus.api.service.practice1.BeanServicePr1;
import com.hiberus.api.service.practice1.BeanServicePr3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BeanServicePr1Impl implements BeanServicePr1 {

    public BeanServicePr1Impl() {
        System.out.println("BeanServicePr1Impl constructed!");
    }

    @Override
    public void init() {

    }

    @Override
    public String sayHello() {
        return "Hello1";
    }

}
