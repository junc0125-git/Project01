package com.unit08;

/**
 * @author cj
 * @create 2020-10-23 19:51
 *
 * 两个不同的线程执行不同的功能
 * Thread1 输出0-100内的奇数
 * Thread2 输出0-100内的偶数
 *
 * 4步走：
 *1，创建子类继承Thread类
 * 2，重写run()方法-->将线程所要做的工作放到run方法中
 * 3，新建一个对象
 * 4，调用start方法启动线程
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1=new MyThread1();
//        MyThread2 myThread2=new MyThread2();
//        myThread1.start();
//        myThread2.start();
        //用于对象线程只调用了一次，故可以使用匿名子类的方式
//        new Thread().start();//此处调用的是Thread类的run方法
        new Thread(){//对其方法进行重写，表示匿名子类
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==0)
                        System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==1)
                        System.out.println(Thread.currentThread().getName()+":"+i);

                }
            }
        }.start();

    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==1)
                System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}