package com.wxblockchain.com.learning.jdk8learning;

import java.util.Scanner;

public class Jdk8Learning {

    public static void main(String[] args) {

//        LongAdder  striped64

        /*while(true) {
            System.out.print("程然：");
            String str = sc.next();
            System.out.println("今金：" + str.substring(0,str.length()-1));
        }*/
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入您的号码：");
            String str = sc.next();
//            System.out.println("您输入数字："+ str);
            double randomValue = Math.floor(Math.random() * 10);
            System.out.println("中奖号码是："+randomValue);
            if(Double.parseDouble(str) == randomValue){
                System.out.println("恭喜您，中奖了！");
            }else{
                System.out.println("很遗憾，下次继续哦！");
            }
            System.out.println("是否继续？y/n");
            str = sc.next();
            if (str.equalsIgnoreCase("n")){
                System.out.println("欢迎下次再来！");
                sc.next();
            }

        }
    }

}
