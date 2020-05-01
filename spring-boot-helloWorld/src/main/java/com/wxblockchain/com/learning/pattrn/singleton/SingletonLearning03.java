package com.wxblockchain.com.learning.pattrn.singleton;


/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但是在多线程访问时会有问题
 */
public class SingletonLearning03 {

    private static  SingletonLearning03 instance;

    private SingletonLearning03(){}

    public static SingletonLearning03 getInstance(){
        if(null == instance){//如果多个线程都在此处判断为空，则会继续实例化对象，最终会创建多个实例
            try {
                //睡眠1毫秒
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonLearning03();
        }
        return instance;
    }

    /**
     * 多线程验证
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0;i < 100;i++){
            //创建线程
/*            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonLearning03.getInstance().hashCode());
                }
            }).start();*/
            //lambda 表达式改写(类里面只有一个方法的写法)
            new Thread(()->{
                //打印hashcode，一般不同对象的hashcode值不同
                //此处会出现一些hashcode值不同的情况，说明创建了多个对象，与单例思想不符
                System.out.println(SingletonLearning03.getInstance().hashCode());
            }).start();
        }
    }
}
