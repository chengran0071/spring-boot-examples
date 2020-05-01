package com.neo.com.learning.pattrn.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象的傻等
 */
public class Child {
    private boolean cry = false;
    public boolean isCry(){
        return cry;
    }

    public void wakeup(){
        System.out.println("Wake up! Cry wuuwuwu...");
        cry = true;
        //遍历观察者,调用方法
        for (Observer observer : observers){
            observer.actionOnWakeup();
        }
    }

    /**
     * 小孩醒了，在特定的场景下，观察者做特定的处理
     */
    public void wakeupOnEvent(EventSource eventSource){
        cry = true;
        for (ObserverEvent observerEvent : observerEvents){
            observerEvent.wakeUpActionOnEvent(eventSource);
        }
    }


    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    private List<ObserverEvent> observerEvents = new ArrayList<>();
    {
        observerEvents.add(new MomListener());
    }
}
