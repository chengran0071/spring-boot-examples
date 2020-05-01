package com.neo.com.learning.pattrn.factory;

import com.neo.com.learning.pattrn.factory.product.Car;
import com.neo.com.learning.pattrn.factory.product.Plane;
import com.neo.com.learning.pattrn.factory.productFactory.CarFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工厂模式
 * 分类：前两个严格来说不属于工厂模式
 * 1.简单工厂
 * 2.静态工厂，比如单例
 * 3.工厂方法
 * 4.抽象工厂
 *
 * 应用：spring ioc（控制反转）
 *
 * 定义：
 * 任何可以产生对象的方法或者类，都可以称为工厂
 * 单例也是一种工厂
 * 为什么有了new之后，还需要工厂：1.灵活控制生产过程；2.对创建的对象进行权限、修饰、日志。。。控制
 *
 * 工厂方法跟抽象工厂的区别以及对应场景：
 * 工厂方法：对于产品的扩产比较方便，加新产品，加新工厂即可
 * 抽象工厂：对于产品族的扩展比较方便
 *
 * 更好的解决方案：
 * bean工厂
 */
public class FactoryLearning {

    public static void main(String[] args) {
        String str = "/rhine2/contract/2020/aaa.pdf";
        String[] split = str.split("/", -1);
        System.out.println(split.length);
        String dateStr = "2020-02-11";
        String dateStr1 = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse.equals(new Date()));

        //1.创建一辆车，并且可以跑
        Car c = new Car();
        c.go();

        //2. 如果我想进行扩展，想要换飞机，
        //可以再new一个plane，然后调用go方法
        Plane p = new Plane();
        p.go();

        //3. 如果又要换一个交通工具呢？继续new？任意定制交通工具
        //创建一个交通工具接口，然后创建多态对象，指向想要使用的具体交通工具，调用go方法
        Moveable m = new Plane();//只需要修改此处的具体交通工具，后面方法不用再改变，这一步可以放到配置文件里
        m.go();

        //4.任意定制交通工具的生产过程，比如赋给权限，又要如何实现
        //把产生对象的过程不要使用new，而是交给工厂
        //步骤：创建交通工具的工厂---> 通过工厂创建对象----> 调用对象的go方法
        Moveable m1 = new CarFactory().createCar();//只需要修改carfactory为对应的交通工具工厂即可
        m1.go();


    }
}

