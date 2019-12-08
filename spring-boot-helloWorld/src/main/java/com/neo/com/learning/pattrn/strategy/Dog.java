package com.neo.com.learning.pattrn.strategy;

public class Dog  implements  ComparableSon<Dog>{
    int food;

    public Dog(int food){
        this.food = food;
    }

    //与cat中进行比较，为什么此处可以用dog作为入参类型
    @Override
    public int compareToSon(Dog d) {

        if(this.food < d.food) return -1;
        else if(this.food > d.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{food="+food+')';
    }
}
