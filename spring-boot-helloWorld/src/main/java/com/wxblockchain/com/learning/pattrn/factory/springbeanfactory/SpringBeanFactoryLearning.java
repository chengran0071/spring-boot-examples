package com.wxblockchain.com.learning.pattrn.factory.springbeanfactory;

import learning.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringBeanFactoryLearning {
    public static void main(String[] args) {
        //1.获取ioc核心容器，并根据idh获取对象
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
//        applicationContext.getApplicationName();

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
        System.out.println(myTestBean);
    }
}
