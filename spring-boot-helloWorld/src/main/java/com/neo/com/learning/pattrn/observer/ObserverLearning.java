package com.neo.com.learning.pattrn.observer;

/**
 * 观察者模式
 */
public class ObserverLearning {

    public static void main(String[] args) {
        //1.一个小孩，哭的时候，开始喂食
        boolean cry = false;
        while(!cry){
            //进行处理
        }

        //2.使用面向对象  与上一个没区别，只是面上对象跟面向过程
        Child child = new Child();
        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observering....");
        }

        //3.
        ChildObserver childObserver  = new ChildObserver();
        childObserver.wakeup();


        //4.加入多个观察者,在观察类里面增加观察者与观察者调用的方法
        //缺点：耦合度太高
        childObserver.wakeup();

        //5.创建一个observer接口，所有观察者实现该接口，在小孩醒的时候，则遍历观察者的对应处理方法
        child.wakeup();

        //6.有时候可能需要根据不同的情景，选择对应的观察者进行处理;或者观察者需要针对不同的场景做特定的处理
        EventSource eventSource = new EventSource(100,"bed");
        child.wakeupOnEvent(eventSource);

        //7.一般而言，在处理时，需要知道事件源对象是谁

    }




}
