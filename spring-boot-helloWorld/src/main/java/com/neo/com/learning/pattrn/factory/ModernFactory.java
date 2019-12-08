package com.neo.com.learning.pattrn.factory;

/**
 * 具体工厂，继承自抽象工厂
 */
public class ModernFactory extends AbstractFactory {

    @Override
    AbstractFood createFood() {
        return new Bread();
    }

    @Override
    AbstractVehicle createVehicle() {
        return new Car();
    }

    @Override
    AbstractWeapoon createWeapon() {
        return new AK47();
    }
}
