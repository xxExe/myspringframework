package org.myspringframework.beans.factory.context;

import org.myspringframework.beans.factory.BeanFactory;

public class ApplicationContext {

    private BeanFactory beanFactory;

    public ApplicationContext(String basePackage){
        System.out.println("---->>> START CONTEXT <<<----");

        try {
            beanFactory = new BeanFactory();
            // ищем все бины в пакете
            beanFactory.instantiate("com.app");
            // выставляем значения в поля Autowired
            beanFactory.populateProperties();
            // указываем нужным бинам их имена
            beanFactory.injectBeanNames();
            // указываем нужным бинам фаборику бинов
            beanFactory.injectBeanFactorys();
            // выполняем логику после заполнения свойств
            beanFactory.initializeBeans();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("---->>> FINISH CONTEXT <<<----");
    }

    public void close(){
        beanFactory.close();

        for ( Object bean : beanFactory.getBeans().values()){
            if (bean instanceof ApplicationListener){
                
            }
        }
    }

}
