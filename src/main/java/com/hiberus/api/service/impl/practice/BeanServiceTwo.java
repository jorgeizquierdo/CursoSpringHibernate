package com.hiberus.api.service.impl.practice;

import com.hiberus.api.service.BeanService;

import javax.annotation.PostConstruct;

/**
 * Created by Daniel on 14/06/2016.
 */
//@Component(value = "beanServiceTwo")
public class BeanServiceTwo implements BeanService {

    @PostConstruct
    @Override
    public void init() {

        System.out.println("beanServiceTwo initialized!");
    }

    @Override
    public String sayHello() {

        return "Hello2";
    }

}