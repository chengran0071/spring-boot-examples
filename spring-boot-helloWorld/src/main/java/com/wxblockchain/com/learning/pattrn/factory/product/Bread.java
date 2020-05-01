package com.wxblockchain.com.learning.pattrn.factory.product;

import com.wxblockchain.com.learning.pattrn.factory.abstractFactory.AbstractFood;

public class Bread extends AbstractFood {

    @Override
    public void printName() {
        System.out.println("mianbao.....");
    }
}
