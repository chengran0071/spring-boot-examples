package com.neo.com.learning.pattrn.strategy;

/**
 * comparable接口，如果想要进行比较的对象，需要实现此接口
 * 注意：此处接口使用泛型，这样减少了实现类中的类型转换，否则每次需要进行类似 Cat c = (Cat)o 的转化才能继续执行后续代码
 */
public interface ComparableSon<T> {
    /**比较的方法，返回值分别为 -1 1 0 ，表示小于，大于，等于*/
    int compareToSon(T o);
}
