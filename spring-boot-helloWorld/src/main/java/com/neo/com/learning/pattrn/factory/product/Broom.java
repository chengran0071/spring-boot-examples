package com.neo.com.learning.pattrn.factory.product;

import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractVehicle;

public class Broom extends AbstractVehicle {
    @Override
    public void go(){
        System.out.println("broombroom...");
    }
}
