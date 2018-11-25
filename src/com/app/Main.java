package com.app;

import com.app.processor.ConsoleOutputPostProcessor;
import com.app.processor.PostConstructProcessor;
import org.myspringframework.beans.factory.BeanFactory;
import org.myspringframework.beans.factory.context.ApplicationContext;

public class Main {

    private static final String basePackage = "com.app";

    public static void main(String[] args) {
        System.out.println("---Start---");

        BeanFactory beanFactory = new BeanFactory();
        beanFactory.addPostProcessor(new ConsoleOutputPostProcessor());
        beanFactory.addPostProcessor(new PostConstructProcessor());

        try {

            ApplicationContext applicationContext = new ApplicationContext(basePackage);

       /*     // ищем все бины в пакете
            beanFactory.instantiate(basePackage);
            // выставляем значения в поля Autowired
            beanFactory.populateProperties();
            // указываем нужным бинам их имена
            beanFactory.injectBeanNames();
            // указываем нужным бинам фаборику бинов
            beanFactory.injectBeanFactorys();
            // выполняем логику после заполнения свойств
            beanFactory.initializeBeans();

            beanFactory.getBean("productService");

            PromotionService promotionService = (PromotionService) beanFactory.getBean("promotionService");
            System.out.println(promotionService.getBeanName());
            System.out.println(promotionService.getBeanFactory());

            // закрываем фабрику
            beanFactory.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----End----");

    }
}