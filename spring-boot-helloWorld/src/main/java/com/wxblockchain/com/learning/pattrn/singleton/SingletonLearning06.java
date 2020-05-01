package com.wxblockchain.com.learning.pattrn.singleton;

/**
 * 静态内部类的方式
 *
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 *
 */
public class SingletonLearning06 {

    private static SingletonLearning06 instance;

    private SingletonLearning06(){}

    public static synchronized  SingletonLearning06 getInstance(){
        return SingletonLearningHorder.INSTANCE;

    }

    private static  class  SingletonLearningHorder{
        private  static final SingletonLearning06 INSTANCE = new SingletonLearning06();
    }
}
