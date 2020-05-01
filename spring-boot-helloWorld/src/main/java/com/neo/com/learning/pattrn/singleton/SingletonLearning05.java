package com.neo.com.learning.pattrn.singleton;

/**
 * 双重检查
 */
public class SingletonLearning05 {

    //需要加volatile关键字，防止指令重排，可能会在未实例化的时候返回instance （JIT优化成本地代码时会发生指令重排）
    private static volatile  SingletonLearning05 instance;

    private SingletonLearning05(){}

    public static synchronized  SingletonLearning05 getInstance(){

        if(null == instance){//注意，如果有多个线程都判断为空，则进入同步代码块
            synchronized (SingletonLearning05.class){//此处可能有多个线程在等待锁
                if (null != instance) return instance;//需要再做一次检验，防止创建多个实例
                instance = new SingletonLearning05();
            }
        }
        return instance;
    }
}
