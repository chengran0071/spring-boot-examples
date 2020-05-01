package com.wxblockchain.com.learning.algorithm;

import com.wxblockchain.com.learning.util.AlgorithmUtil;

/**
 * 选择排序
 * 1.思路： 选择一个值，记录下标，依次与后面的值比较，如果后面的值比当前值小，则替换。两层for循环
 *
 * 2.优化空间：头尾各选一个数
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = AlgorithmUtil.arr;
        AlgorithmUtil.getCurrenTime();
        for (int i = 0; i < arr.length - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < arr.length;j++ ){
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }

        AlgorithmUtil.printResultAndRuntingTime(arr,"selectionSort");
    }
}
