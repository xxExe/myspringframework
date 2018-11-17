package com.app.processor;

import org.myspringframework.beans.factory.BeanPostProcessor;

public class ConsoleOutputPostProcessor implements BeanPostProcessor {
    @Override
    public Object beforePropertiesSet(Object bean, String beanName) {
        System.out.println(this + ".beforePropertiesSet для бина " + bean);
        return bean;
    }

    @Override
    public Object afterPropertiesSet(Object bean, String beanName) {
        System.out.println(this + ".afterPropertiesSet для бина " + bean);
        return bean;
    }

}