package com.wxblockchain.com.learning.pattrn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * jdk的动态代理
 *
 * 应用场景：
 */
public class JDKProxyLearning implements movable{
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
//        long start = System.currentTimeMillis();
        System.out.println("tank moving clacal....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDKProxyLearning jdkProxyLearning = new JDKProxyLearning();

        //反射，
        /**
         * 三个参数：
         * classload：跟被代理对象使用同一个
         * 接口：被代理对象实现的接口
         */
        /*movable m = (movable) Proxy.newProxyInstance(JDKProxyLearning.class.getClassLoader(),
                new Class[]{movable.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method "+ method.getName()+" start...");
                        Object o = method.invoke(jdkProxyLearning, args);
                        System.out.println("method "+ method.getName()+" end...");
                        return o;
                    }
                });*/
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");


        movable m = (movable) Proxy.newProxyInstance(JDKProxyLearning.class.getClassLoader(),
                new Class[]{movable.class},
                new LogHandle(jdkProxyLearning));
        m.move();
    };
}


/**
 * 实现
 */
class  LogHandle implements   InvocationHandler{
    JDKProxyLearning jdkProxyLearning;
    public LogHandle(JDKProxyLearning jdkProxyLearning){
        this.jdkProxyLearning = jdkProxyLearning;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("method "+ method.getName()+" start...");
        Object o = method.invoke(jdkProxyLearning, args);
        System.out.println("method "+ method.getName()+" end...");
        return o;
    }
}
