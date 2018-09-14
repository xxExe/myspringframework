package org.springframework.beans.factory;

import org.springframework.beans.factory.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    private Map<String, Object> singletonBeans = new HashMap<>();

    private Object getBean(String name){
        return singletonBeans.get(name);
    }

    /**
     * Создает экземпляры классов, из пакета basePackage
     * и кладет их в Map singletonBeans
     * @param basePackage
     */
    public  void instantiate(String basePackage) throws IOException, URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // получаем загрузчик классов
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String basePath = basePackage.replace(".","/");

        Enumeration<URL> resources = classLoader.getResources(basePackage.replace(".","/"));

        while (resources.hasMoreElements()){
            URL resUrl = resources.nextElement();

            File file = new File(resUrl.toURI());
            for ( File classFile : file.listFiles()){
                String fileName = classFile.getName();
                if (isClass(fileName)){

                    String className = getNameWithoutExtension(fileName);

                    Class classObject = Class.forName(basePackage +"."+ className);

                    if (classObject.isAnnotationPresent(Component.class)){
                       // System.out.println("Component found: " + classObject.getName());
                       // Создаем объект класса
                       Object instance = classObject.newInstance();
                       String beanName = getIdForBean(className);

                       singletonBeans.put(beanName, instance);

                    }
                }
            }
        }
    }




    private String getNameWithoutExtension(String fileName){
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private boolean isClass(String filename){
        return  filename.endsWith(".class");
    }

    private String getIdForBean(String beanClassName) {
        return beanClassName.substring(0,1).toLowerCase() + beanClassName.substring(1);
    }

}
