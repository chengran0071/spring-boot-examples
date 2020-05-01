package com.neo.com.learning.algorithm;

import com.neo.com.learning.util.AlgorithmUtil;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = AlgorithmUtil.arr;
        AlgorithmUtil.getCurrenTime();
        for (int i = arr.length -1;i > 0;i--){
            for (int j = 0; j < i;j++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        AlgorithmUtil.printResultAndRuntingTime(arr,"bubbleSorts");
    }
}
