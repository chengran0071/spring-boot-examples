package com.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearning {


    public static void main(String[] args) {

        /**
         * 一、把类扫描出来-----出来干了什么事情
         * 把bean实例化
         * 1.调用构造方法，传入被javaconfig注解了的配置类
         */
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //还可以调用xml配置的初始化方法
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
/*        //1.上面调用的有参构造函数，内部会进行注册跟reflush
        annotationConfigApplicationContext.register(SpringConfig.class);
        annotationConfigApplicationContext.refresh();*/

        /**
         * 加载bean的顺序：
         * 1.解析
         */
        System.out.println(annotationConfigApplicationContext.getBean(Chengran.class));
    }
}
