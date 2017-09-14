package com.hiberus.api.service.impl.practice;

import com.hiberus.api.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Daniel on 14/06/2016.
 */
//@DependsOn(value = "beanServiceTwo")
@Component(value = "beanServiceOne")
public class BeanServiceOne implements BeanService {

    /*@Autowired
    private BeanServiceTwo beanServiceTwo;*/

    @PostConstruct
    @Override
    public void init() {

        System.out.println("beanServiceOne initialized!");

        //System.out.println(this.beanServiceTwo.getClass());
    }

    @Override
    public String sayHello() {

        return "Hello";
    }

}