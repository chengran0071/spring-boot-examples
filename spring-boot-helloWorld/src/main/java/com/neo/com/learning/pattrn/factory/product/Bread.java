package com.neo.com.learning.pattrn.factory.product;

import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractFood;

public class Bread extends AbstractFood {

    @Override
    public void printName() {
        System.out.println("mianbao.....");
    }
}
