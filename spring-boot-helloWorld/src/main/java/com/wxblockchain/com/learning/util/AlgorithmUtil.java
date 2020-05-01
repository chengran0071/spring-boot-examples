package com.wxblockchain.com.learning.util;

import java.util.Random;

/**
 * 算法中使用到的工具方法
 */
public class AlgorithmUtil {
    private static long startTime;

    public static  int[] arr = new int[1000];
    static {
        Random random = new Random();
        for (int i = 0; i < 1000;i++){
            arr[i] = random.nextInt(1000);
        }
    }

    public static void getCurrenTime(){
        startTime = System.currentTimeMillis();
    }

    public static void calMethodRunningTime(String methodName){
        System.out.println("\n"+ methodName+ "运行了：" + (System.currentTimeMillis() - startTime) + " ms");
    }


    /**
     *打印结果以及方法运行时间
     */
    public static void printResultAndRuntingTime(int[] arr,String methodName) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "  ");
        }
        calMethodRunningTime(methodName);
    }

    public static void swapArry(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
