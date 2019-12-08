package com.neo.com.learning.pattrn.factory;

/**
 * 抽象工厂的父类
 */
public abstract  class AbstractFactory {

    abstract AbstractFood createFood();

    abstract AbstractVehicle createVehicle();

    abstract AbstractWeapoon createWeapon();
}
