package com.neo.com.learning.pattrn.singleton;

/**
 * 单例模式
 *
 * 饿汉模式，比较实用！
 * 类加载到内存后，就实例化一个单例，jvm 保证线程安全
 * 唯一缺点，不管使用与否，类加载时就完成实例化
 *
 *
 *
 * 1.使用场景：只需要有一个实例，比如manager，factory
 * 2.写法，有八种，其中两种是完美无缺的，但是一般工作中不一定使用这两种
 */
public class SingletonLearning01 {
    /**1.首先，定义一个SingletonLearning对象*/
    private static  final SingletonLearning01 INSTANCE = new SingletonLearning01();

    /**2.然后，私有化无参构造方法*/
    private SingletonLearning01(){}

    /**3.提供静态工厂方法，返回实例数据*/
    public static SingletonLearning01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {

    }

}
