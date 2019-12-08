package com.neo.com.learning.pattrn.factory;

public class CarFactory {

    public Moveable createCar(){
        //前置处理
        System.out.println("a car created!");

        return new Car();
    }
}
