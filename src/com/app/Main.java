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
            // указываем нужным бинам фаборику бинов
            beanFactory.injectBeanFactorys();

            beanFactory.getBean("productService");

            PromotionService promotionService = (PromotionService) beanFactory.getBean("promotionService");
            System.out.println(promotionService.getBeanName());
            System.out.println(promotionService.getBeanFactory());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----End----");

    }
}