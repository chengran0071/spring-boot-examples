package com.neo.com.learning.pattrn.observer;

public class Mum implements Observer{
    public void hug(){

        System.out.println("mom huging....");
    }

    @Override
    public void actionOnWakeup() {
        System.out.println("mom huging....");
    }
}
