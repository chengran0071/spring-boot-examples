package com.wxblockchain.com.learning.pattrn.factory.product;

import com.wxblockchain.com.learning.pattrn.factory.Moveable;
import com.wxblockchain.com.learning.pattrn.factory.abstractFactory.AbstractVehicle;

public class Car extends AbstractVehicle implements Moveable {

    @Override
    public void go(){

        System.out.println("Car go wuwuwuwu....");
    }



}
