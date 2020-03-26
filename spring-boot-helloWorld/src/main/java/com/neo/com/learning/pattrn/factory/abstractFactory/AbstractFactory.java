package com.neo.com.learning.pattrn.factory.abstractFactory;

/**
 * 抽象工厂的父类
 * 生产的产品单一，但是
 */
public abstract  class AbstractFactory {

    protected abstract AbstractFood createFood();

    protected abstract AbstractVehicle createVehicle();

    protected abstract AbstractWeapoon createWeapon();
}
