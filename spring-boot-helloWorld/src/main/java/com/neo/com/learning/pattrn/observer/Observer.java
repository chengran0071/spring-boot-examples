package com.neo.com.learning.pattrn.observer;

public interface Observer {
    //任何观察者在小孩醒的时候，都调用该方法
    void actionOnWakeup();
}
