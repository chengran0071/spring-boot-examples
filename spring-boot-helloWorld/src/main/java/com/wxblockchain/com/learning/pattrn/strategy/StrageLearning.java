package com.wxblockchain.com.learning.pattrn.strategy;

import java.util.Arrays;

/**
 * 策略模式
 *
 * java.util.comparator接口
 * java.lang.comparable接口
 */
public class StrageLearning {

    public static void main(String[] args) {

        //对数据进行排序
        int[] a = {9,2,3,4,5,6};
        Sorter sorter = new Sorter();
        //这个方法可以对int数据进行排序，如果现在想对double方法进行排序呢？如何扩展
        //方法一、.直接重载方法，入参类型修改成想要的方法；
        //方法二、如果对cat进行排序呢？
        sorter.sort(a);
        System.out.println(Arrays.toString(a));

        //对猫进行排序；
        //1.对猫定义排序规则；
        //2.重载sort方法
        Cat[] cats = {new Cat(3,3),new Cat(2,2),new Cat(5,5)};
        sorter.sortCat(cats);
        System.out.println(Arrays.toString(cats));

        //如果又要对狗进行比较呢？
        //1.定义的类实现comparable接口，然后重写比较的方法；
        //2.排序的方法，传入的方法
        Dog[] dogs = {new Dog(3),new Dog(4),new Dog(1)};
        sorter.sortTarget(dogs);
        System.out.println(Arrays.toString(dogs));

        //如果我希望比较的时候是按照指定的属性进行比较，比如我想按照猫的身高（或者体重）进行比较，要怎么实现呢?
        //1.定义类比较器 comparator
        //2.排序方法重载，入参中传入数组以及比较器，这样可以实现根据对应的比较规则进行排序
        //注意，程序设计要求对修改关闭，对扩展开放。故使用此方法可以有效的进行扩展
        sorter.sortComparator(dogs,new DogComparator());//入参为排序的数组，以及排序的策略
        System.out.println(Arrays.toString(dogs));
    }
}
