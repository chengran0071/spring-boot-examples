package com.neo.com.learning.pattrn.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib生成代理，比jdk简单
 *
 * 但是如果被代理类市final，cglib无法代理，而jdk的asm机制可以实现
 */
public class CglibProxyLearning {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());//相当于invocationhandle
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}


class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return result;
    }
}

/**
 * 需要被代理的类，没有实现任何接口
 */
class Tank{

    public void move(){

        System.out.println("tank moving claclacla...");
    }
}