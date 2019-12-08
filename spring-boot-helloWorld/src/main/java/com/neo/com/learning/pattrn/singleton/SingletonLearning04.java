package com.neo.com.learning.pattrn.singleton;

/**
 * 加锁
 */
public class SingletonLearning04 {
    private static SingletonLearning04 instance;

    private SingletonLearning04(){}

    public static synchronized  SingletonLearning04 getInstance(){

        if(null == instance){
            instance = new SingletonLearning04();
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
