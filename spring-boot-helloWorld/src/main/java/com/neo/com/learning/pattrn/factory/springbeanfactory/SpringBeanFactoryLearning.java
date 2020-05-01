package com.neo.com.learning.pattrn.factory.springbeanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryLearning {
    public static void main(String[] args) {
        //1.获取ioc核心容器，并根据idh获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.getApplicationName();
    }
}
