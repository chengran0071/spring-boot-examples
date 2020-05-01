package com.wxblockchain.com.learning.pattrn.observer;

public class Dad implements Observer{
    public void feed(){

        System.out.println("dad feeding....");
    }

    @Override
    public void actionOnWakeup() {
        System.out.println("dad feeding....");
    }
}
