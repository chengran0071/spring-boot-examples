package com.neo.com.learning.threadlearning;


public class ThreadLearning extends  Thread{

    private int count = 10;

    private Object object = new Object();//可以使用this代替此变量

    @Override
    public void run() {
        this.getLock();
    }

    /** 未枷锁的方法，与后续方法做比较*/
    public  void getNoLock(){
            count--;
            System.out.println("nolock" + Thread.currentThread().getName()+"count=" + count);
    }

    /**
     * synchronized 是锁住对象
     */
    public  void getLock(){
        synchronized (this){//获取当前对象的锁，才可以继续走后续逻辑
            count--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock"+Thread.currentThread().getName()+"count=" + count);
        }
    }

    /**
     * 与上述写法等效
     */
    public synchronized void getLock2(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count=" + count);
    }

    public static void main(String[] args) {
        //1.调用线程中未加锁的方法getNoLock(),可能出现重复的数据，与预期记过不同
        //2.调用 getlock 方法
        ThreadLearning threadLearning = new ThreadLearning();
//        for(int i = 0;i < 10; i++){
//            Thread thread = new Thread(threadLearning);
//            thread.start();
//        }

        //问题2. 一个线程调用加锁的方法，另一个线程调用非加锁方法，会被阻塞吗？/
        //答：不会，因为非加锁方法不需要申请锁
        new Thread(()->threadLearning.getLock()).start();//同步方法中有等待
        new Thread(()->threadLearning.getNoLock()).start();//非同步方法会先输出结果


        //问题3. 写加锁，读不需要加锁，对吗？
        //答：不对，不加锁的方法不会阻塞，所以有可能出现不可重复读的情况。

        //问题4. 一个同步方法能否调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请时仍然会得到
        //该对象的锁。也就是说synchronized获得的锁是可重入的；
        //子类同步方法调用父类的同步方法，也没问题。




        //问题5. 什么情况下出现死锁？如何避免死锁
        //答： 有两个共享变量，在方法中顺序调用，被两个线程分别锁住。 A->B  B->A



        //问题6. 程序执行过程中，出现异常，则锁被释放。，所以并发处理时，有异常要小心，可能出现数据不一致的问题；
        //


        //问题7. volatile 关键字，保证可见性
        //jmm（java内存模型），每个线程执行过程中有自己内存（包含cpu缓冲区），从主内存中读取数据，然后在
        //缓冲区中进行修改，再写回去。 所以如果不加volatile关键字，线程会一直从自己的cpu缓冲区中读取数据，
        //加了之后，修改的值会通知其他线程的cpu缓冲区。


        //问题8. 锁对象发生改变，则重新获取锁。

        //问题9. 不要以string字符串常量作为锁对象
        new Thread(()->threadLearning.m1()).start(); //s1 的 锁
        new Thread(()->threadLearning.m2()).start(); //s2 的锁，其实与s1 是同一个对象的锁 hello字符串

        //问题10. 实现一个容器，提供两个方法，add，size，写两个线程，线程1添加10个元素，线程2实现
        //监控元素的个数，当个数到第五个时，线程2给出提示并结束
        //wati，notify   countdownlatch更好

        //问题11. 实现一个同步容器，拥有put get 方法，以及getcount方法，能够支持两个生产者线程以及10个消费者线程
        //方法一。使用wait，notifyall 。 wait与while同时使用，这样在获得锁的时候，会继续检查一遍，而使用if，则直接执行后面的代码
        //方法二、 使用lock和condition，指定哪些线程被唤醒

        //问题12. threadlocal 线程局部变量
        //
        
    }

    String s1 = "hello";
    String s2 = "hello";
    void m1(){
        synchronized (s1){
            try {
                Thread.sleep(1000);
                System.out.println("输出s1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void m2(){
        synchronized (s2){
            System.out.println("输出s2");
        }
    }
}
