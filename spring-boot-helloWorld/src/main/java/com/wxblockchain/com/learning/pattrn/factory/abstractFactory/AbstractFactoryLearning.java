package com.wxblockchain.com.learning.pattrn.factory.abstractFactory;

import com.wxblockchain.com.learning.pattrn.factory.product.AK47;
import com.wxblockchain.com.learning.pattrn.factory.product.Bread;
import com.wxblockchain.com.learning.pattrn.factory.product.Car01;
import com.wxblockchain.com.learning.pattrn.factory.productFactory.ModernFactory;

/**
 * 抽象工厂
 */
public class AbstractFactoryLearning {

    public static void main(String[] args) {
        //1.创建一辆车，一个司机，给他一个ak47，一个面包,需要如何实现
        Car01 c = new Car01();
        c.go();
        AK47 ak = new AK47();
        ak.shoot();
        Bread b = new Bread();
        b.printName();

        //2.如果现在有魔法界的司机，使用扫帚、魔法棒、毒蘑菇，上面六句话都要重新写
        //怎样实现一个新的族群加入，代码的修改范围最小。
        //使用抽象工厂
        //步骤：抽象工厂-->抽象产品-->具体产品 ---> 具体工厂
        //注意：此处使用抽象类而没用使用接口，是语义问题，形容词用接口，名词用抽象类
        AbstractFactory f = new ModernFactory();//调用具体工厂，创建需要的族群，更换族群也只需要修改这一处代码
        AbstractVehicle av = f.createVehicle();
        av.go();
        AbstractFood af = f.createFood();
        af.printName();
        AbstractWeapoon aw = f.createWeapon();
        aw.shoot();

    }
}
