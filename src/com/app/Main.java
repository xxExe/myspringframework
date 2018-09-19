package com.app;

import org.myspringframework.beans.factory.BeanFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("---Start---");


        BeanFactory beanFactory = new BeanFactory();
        try {

            beanFactory.instantiate("com.app");


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("----End----");



    }
}