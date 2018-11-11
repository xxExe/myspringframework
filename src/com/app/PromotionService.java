package com.app;

import org.myspringframework.beans.factory.BeanFactory;
import org.myspringframework.beans.factory.BeanNameAware;
import org.myspringframework.beans.factory.BeanFactoryAware;
import org.myspringframework.beans.factory.InitializatingBean;
import org.myspringframework.beans.factory.annotation.stereotype.Component;

@Component
public class PromotionService implements BeanNameAware, BeanFactoryAware, InitializatingBean {

    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanNAme(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet from " + this);
    }

    public String getBeanName() {
        return beanName;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

}
