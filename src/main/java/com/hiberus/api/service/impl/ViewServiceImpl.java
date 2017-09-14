package com.hiberus.api.service.impl;

import com.hiberus.api.service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by Daniel on 19/06/2016.
 */
//@Service("viewerService")
public class ViewServiceImpl implements ViewerService {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    @Override
    public void showContext() {

        for (String beanName : this.applicationContext.getBeanDefinitionNames()) {

            System.out.println("[BEAN] " + beanName);
        }
    }

}