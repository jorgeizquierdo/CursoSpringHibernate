package com.hiberus.api.service.impl.practice.resolved;

import com.hiberus.api.service.BeanService;
import com.hiberus.api.service.PracticeBean;
import com.hiberus.api.service.impl.practice.BeanServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by Daniel on 16/06/2016.
 */
//@Component
public class PracticeBeanResolvedImpl implements PracticeBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String randomHello() {

        Map<String, BeanService> beans = this.applicationContext.getBeansOfType(BeanService.class);

        Iterator<BeanService> beansIterator = beans.values().iterator();

        int toSelect = randomFromZeroToMax(beans.size());

        for (int pos = 0; pos < beans.size(); pos++) {

            BeanService beanService = beansIterator.next();

            if (pos == toSelect) return beanService.sayHello();
        }

        return "HelloDefault";
    }

    @Override
    public void doSomething() {

        ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) this.applicationContext).getBeanFactory();
        BeanDefinitionRegistry factoryDefinition = (BeanDefinitionRegistry) beanFactory;

        factoryDefinition.removeBeanDefinition("beanServiceOne");
        beanFactory.registerSingleton("beanServiceOne", new BeanServiceTwo());
    }

    private int randomFromZeroToMax(int max) {

        return new Random().nextInt(max);
    }

}