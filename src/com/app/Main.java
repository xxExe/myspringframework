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
            // указываем нужным бинам их имена
            beanFactory.injectBeanNames();

            beanFactory.getBean("productService");

            PromotionService promotionService = (PromotionService) beanFactory.getBean("promotionService");
            System.out.println(promotionService.getBeanName());

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("----End----");


    }
}