package com.neo.com.learning.pattrn.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程同步，还可以防止序列化
 *
 * 序列化问题，java的反射可以通过class创建对象，所以前面的方式都可以通过反射的方式反序列化，创建多个实例对象
 * 枚举单例不会被反序列化的原因，时枚举类没有构造方法
 */
public enum  SingletonLearning08 {
    INSTANCE;


}
