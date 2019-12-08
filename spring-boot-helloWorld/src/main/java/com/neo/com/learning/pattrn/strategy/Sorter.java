package com.neo.com.learning.pattrn.strategy;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Sorter<T> {


    /**对int数据进行排序*/
    public int[] sort(int[] arrs){
        for(int i = 0; i < arrs.length -1;i++){
            int minPos = i;
            for(int j = i + 1;j < arrs.length;j++){
                minPos = arrs[j] < arrs[minPos] ? j : minPos;
            }
            swap(arrs,i,minPos);

        }
        return arrs;
    }

    static void swap(int[] arrs,int i,int j){
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }


    /**对cat数据进行排序*/
    public Cat[] sortCat(Cat[] arrs){
        for(int i = 0; i < arrs.length -1;i++){
            int minPos = i;
            for(int j = i + 1;j < arrs.length;j++){
                minPos = arrs[j].compareTo(arrs[minPos]) == -1 ? j : minPos;
            }
            swapCat(arrs,i,minPos);

        }
        return arrs;
    }

    static void swapCat(Cat[] arrs,int i,int j){
        Cat temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    /**现在传入参数改为comparable（此处为自定义的comparable，参照的是jdk的comparable接口，
     熟悉泛型使用）
     此时可以做一个通用方法进行比较
     */
    public void sortTarget(ComparableSon[] arrs){
        for(int i = 0; i < arrs.length -1;i++){
            int minPos = i;
            for(int j = i + 1;j < arrs.length;j++){
                minPos = arrs[j].compareToSon(arrs[minPos]) == -1 ? j : minPos;
            }
            swapComparable(arrs,i,minPos);

        }
    }

    static void swapComparable(ComparableSon[] arrs,int i,int j){
        ComparableSon temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }


    public  void sortComparator(T[] arrs,CompatorSon compatorSon){
        for(int i = 0; i < arrs.length -1;i++){
            int minPos = i;
            for(int j = i + 1;j < arrs.length;j++){
                minPos = compatorSon.compare(arrs[j],arrs[minPos]) == -1 ? j : minPos;
            }
            swapComparator(arrs,i,minPos);

        }
    }
     void swapComparator(T[] arrs,int i,int j){
        T temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
