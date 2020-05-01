package com.wxblockchain.com.learning.pattrn.strategy;

public class Cat implements ComparableSon{

    int weight,height;

    public Cat(int weight,int height){
        this.weight = weight;
        this.height = height;
    }

    /**
     * 比较猫的大小
     */
    public int compareTo(Cat c){
        if(this.weight < c.weight) return -1;
        else if(this.weight < c.weight) return  1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{weight="+weight+",height="+height+"}";
    }

    @Override
    public int compareToSon(Object o) {
        Cat c = (Cat)o;
        if(this.weight < c.weight) return -1;
        else if(this.weight < c.weight) return  1;
        return 0;
    }
}
