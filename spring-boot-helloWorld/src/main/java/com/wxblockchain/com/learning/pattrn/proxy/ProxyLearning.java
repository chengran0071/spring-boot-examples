package com.wxblockchain.com.learning.pattrn.proxy;

import java.util.Random;


/**
 * 代理模式
 *
 */
public class ProxyLearning implements movable{

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
//        long end = System.currentTimeMillis();
//        System.out.println("坦克运行了："+(end - start)+"毫秒");
    }

    public void moveAndCount(){
        long start = System.currentTimeMillis();
        move();
        long end = System.currentTimeMillis();
        System.out.println("坦克运行了："+(end - start)+"毫秒");
    }

    public static void main(String[] args) {
        //1.问题：我想记录坦克的移动时间,在移动的时间中前后增加时间记录，然后进行时间相减
        new ProxyLearning().move();

        //2.如果无法修改源代码呢？benchmark查询方法的运行性能
        //可以使用继承，重写方法（此处模拟，我使用重载）

        //3.使用代理
        new TankTimeproxy(new ProxyLearning()).move();

        //4.如何使用代理的组合---静态代理，类似装饰器模式（？还不熟悉）

        //5.如果有stop方法需要代理
        //如果想让logproxy可以重用，不仅可以代理tank，还可以代理其他，则需要将代理类型改为object
        //毕竟日志、时间计算是很多方法都要的东西，这时该怎么办？
        //分离代理行为与被代理对象
        //使用jdk的动态代理
    }
}

/**
 * 代理类
 *
 */
class TankTimeproxy implements  movable{
    ProxyLearning proxyLearning ;
    public   TankTimeproxy(ProxyLearning proxyLearning){
        this.proxyLearning = proxyLearning;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        proxyLearning.move();
        long end = System.currentTimeMillis();
        System.out.println("坦克运行了："+(end - start)+"毫秒");
    }
}

/**
 * 静态代理类,日志代理
 *
 */
class TankLogproxy implements  movable{
    movable m ;
    public   TankLogproxy(movable m){
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("坦克开始运行了："+ System.currentTimeMillis());
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("坦克结束运行了；"+ System.currentTimeMillis());
    }
}

interface movable{
    void move();
}
