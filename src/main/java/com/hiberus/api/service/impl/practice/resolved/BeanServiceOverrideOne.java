package com.hiberus.api.service.impl.practice.resolved;

import com.hiberus.api.service.impl.practice.BeanServiceOne;

/**
 * Created by Daniel on 15/06/2016.
 */
//@Service("beanServiceOverrideOne")
public class BeanServiceOverrideOne extends BeanServiceOne {

    /**
     * BeanPracticeTest.sayHello2()
     *
     * Añadir aspectj exlusion filter sobre BeanServiceOne.
     */
    @Override
    public String sayHello() {

        return "Hello2";
    }

}