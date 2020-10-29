package com.unit08;

import com.unit08.teacher.codes.MyThread;

/**
 * @author cj
 * @create 2020-10-23 19:19
 *
 * 创建Thread方法一：
 *  1，创建一个Thread子类
 *  2，重写run()方法-->将线程执行的操作声明在方法体内
 *  3，声明Thread类的子类对象
 *  4，通过对象调用start方法
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class ThreadCreatMethod01 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();

        //用run方法不会启动线程
//        myThread.run();

        //虽然重写的是run方法，但启动线程用的是start方法，用start方法启动的才是线程
        myThread.start();

        //不能让已经start()的线程再次去start，否则会报错IllegalThreadStateException
//        myThread.start();

        //如果想再次启动一个线程，需要重新去new一个对象
        MyThread myThread1=new MyThread();
        myThread1.start();


        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}
