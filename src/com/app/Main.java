package com.app;

import org.myspringframework.beans.factory.BeanFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Start---");


        BeanFactory beanFactory = new BeanFactory();
        try {

            // ищем все бины в пакете
            beanFactory.instantiate("com.app");
            // выставляем значения в поля Autowired
            beanFactory.populateProperties();

            beanFactory.getBean("ProductService");

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("----End----");


    }
}