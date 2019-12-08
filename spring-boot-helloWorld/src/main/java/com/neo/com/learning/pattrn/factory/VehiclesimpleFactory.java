package com.neo.com.learning.pattrn.factory;


/**
 * 简单工厂，在创建的时候定义对象的权限、日志处理等内容
 * 缺点：可扩展性不好，因为每次都需要在里面新增一个方法
 * 所以可以给每个类给定单独的对象创建工厂
 *
 * 交通工具的方法
 */
public class VehiclesimpleFactory {

    public Car createCar(){
        //定义权限、日志处理----前置处理


        return new Car();
    }

    public Plane createPlane(){
        //定义权限、日志处理----前置处理


        return new Plane();
    }
}
