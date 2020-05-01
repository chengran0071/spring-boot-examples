package com.wxblockchain.com.learning.pattrn.factory.product;

import com.wxblockchain.com.learning.pattrn.factory.abstractFactory.AbstractVehicle;

public class Broom extends AbstractVehicle {
    @Override
    public void go(){
        System.out.println("broombroom...");
    }
}
