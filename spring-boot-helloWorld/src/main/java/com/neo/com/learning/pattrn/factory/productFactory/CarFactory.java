package com.neo.com.learning.pattrn.factory.productFactory;

import com.neo.com.learning.pattrn.factory.product.Car;
import com.neo.com.learning.pattrn.factory.Moveable;

public class CarFactory {

    public Moveable createCar(){
        //前置处理
        System.out.println("a car created!");

        return new Car();
    }
}
