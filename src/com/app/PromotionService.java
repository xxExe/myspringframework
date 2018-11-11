package com.app;

import org.myspringframework.beans.factory.BeanFactory;
import org.myspringframework.beans.factory.BeanNameAware;
import org.myspringframework.beans.factory.annotation.BeanFactoryAware;
import org.myspringframework.beans.factory.annotation.stereotype.Component;

@Component
public class PromotionService implements BeanNameAware, BeanFactoryAware {

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

    public String getBeanName() {
        return beanName;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    
}
