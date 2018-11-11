package org.myspringframework.beans.factory;

import org.myspringframework.beans.factory.annotation.Autowired;
import org.myspringframework.beans.factory.annotation.stereotype.Component;
import org.myspringframework.beans.factory.annotation.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

    private Map<String, Object> singletonBeans = new HashMap<>();

    public Object getBean(String name) {
        return singletonBeans.get(name);
    }

    /**
     * Создает экземпляры классов, из пакета basePackage
     * обрабатывая аннотации @Component и @Service
     * и кладет их в Map singletonBeans
     *
     * @param basePackage
     */
    public void instantiate(String basePackage) throws IOException, URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // получаем загрузчик классов
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String basePath = basePackage.replace(".", "/");

        Enumeration<URL> resources = classLoader.getResources(basePath);

        while (resources.hasMoreElements()) {
            URL resUrl = resources.nextElement();

            File file = new File(resUrl.toURI());
            for (File classFile : file.listFiles()) {
                String fileName = classFile.getName();
                if (isClass(fileName)) {

                    String className = getNameWithoutExtension(fileName);
                    Class classObject = Class.forName(basePackage + "." + className);

                    if (isComponentOrService(classObject)) {
                        // System.out.println("Component found: " + classObject.getName());
                        // Создаем объект класса
                        Object instance = classObject.newInstance();
                        String beanName = getIdForBean(className);
                        System.out.println("Create bean with name = " + beanName + " and value = " + instance);
                        singletonBeans.put(beanName, instance);
                    }
                }
            }
        }
    }

    /**
     * инжектит в поля, отмеченные @Autowired
     * обрабатывает бины из Map singletonBeans
     */
    public void populateProperties() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // цикл по бинам
        for (Object object : singletonBeans.values()) {
            //цикл по полям
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    // Ищем в бинах объект необходимого класса
                    for (Object bean : singletonBeans.values()) {
                        if (bean.getClass().equals(field.getType())) {
                            setFieldValue(object, field, bean);
                        }
                    }
                }
            }
        }
    }

    /**
     * Устанавливаем объекту targetObject в поле targetField значение valueObject
     * Формирует название setter-а и вызывает его
     * <p>
     * Другой вариант: делать поле public, заноcить туда значение,
     * потом возвращать его в private
     *
     * @param targetObject объект
     * @param targetField  поле
     * @param valueObject  значение
     */
    private void setFieldValue(Object targetObject, Field targetField, Object valueObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //формируем "стандартное имя сеттера"
        String setterName = "set" +
                targetField.getName().substring(0, 1).toUpperCase() +
                targetField.getName().substring(1);

        System.out.println("SetterName = " + setterName);

        try {
            Method setter = targetObject.getClass().getMethod(setterName, valueObject.getClass());
            setter.invoke(targetObject, valueObject);
        } catch (Exception e) {
            System.out.println("ERROR: Cannot invoke method " + setterName +
                    " for object " + targetObject + " becouse of: " + e.getCause());
        }

    }


    private String getNameWithoutExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private boolean isClass(String filename) {
        return filename.endsWith(".class");
    }

    private String getIdForBean(String beanClassName) {
        return beanClassName.substring(0, 1).toLowerCase() + beanClassName.substring(1);
    }

    private boolean isComponentOrService(Class classObject) {
        return (classObject.isAnnotationPresent(Component.class) || classObject.isAnnotationPresent(Service.class));
    }

    private void processComponentService(String basePackage) {

    }

}
