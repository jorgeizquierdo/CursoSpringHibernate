package com.hiberus.api.service.impl.practice;

import javax.annotation.PostConstruct;

/**
 * Created by Daniel on 15/06/2016.
 */
//@DependsOn("beanServiceTwo")
//@Service("beanServiceOverrideTwo")
public class BeanServiceOverrideTwo extends BeanServiceTwo {

    @PostConstruct
    @Override
    public void init() {

        //super.init();

        System.out.println("beanServiceOverrideTwo initialized!");
    }

}