package com.neo.com.learning.pattrn.observer;

public class ChildObserver {
    private boolean cry = false;
    private Dad d = new Dad();
    private Mum m = new Mum();

    public boolean isCry(){
        return  cry;
    }

    public void wakeup(){
        cry = true;
        d.feed();
        //增加一个观察者，在里面增加一个观察者的调用方法
        m.hug();
    }
}
