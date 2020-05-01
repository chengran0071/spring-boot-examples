package com.neo.com.learning.pattrn.factory.productFactory;

import com.neo.com.learning.pattrn.factory.product.AK47;
import com.neo.com.learning.pattrn.factory.product.Bread;
import com.neo.com.learning.pattrn.factory.product.Car;
import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractFactory;
import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractFood;
import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractVehicle;
import com.neo.com.learning.pattrn.factory.abstractFactory.AbstractWeapoon;

/**
 * 具体工厂，继承自抽象工厂
 */
public class ModernFactory extends AbstractFactory {

    @Override
    public AbstractFood createFood() {
        return new Bread();
    }

    @Override
    public AbstractVehicle createVehicle() {
        return new Car();
    }

    @Override
    public AbstractWeapoon createWeapon() {
        return new AK47();
    }
}
