package com.app.processor;

import org.myspringframework.beans.factory.BeanPostProcessor;
import org.myspringframework.beans.factory.annotation.PostConstruct;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * выполняет методы, помеченные @PostConstuct
 * до выполнения InitializatingBean.afterPropertiesSet
 */
public class PostConstructProcessor implements BeanPostProcessor {
    @Override
    public Object beforePropertiesSet(Object bean, String beanName) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                try {
                    if (method.getModifiers() == Modifier.PRIVATE) {
                        method.setAccessible(true);
                    }
                    method.invoke(bean);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }

    @Override
    public Object afterPropertiesSet(Object bean, String beanName) {
        return bean;
    }

}