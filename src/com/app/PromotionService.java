package com.app;

import org.myspringframework.beans.factory.BeanNameAware;
import org.myspringframework.beans.factory.annotation.stereotype.Component;

@Component
public class PromotionService implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanNAme(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
