package com.unit08;

import static java.lang.Thread.sleep;

/**
 * @author cj
 * @create 2020-10-24 21:05
 *
 * 创建线程方法二：实现Runnable接口
 *  1，创建一个实现Runnable接口的类
 *  2，实现类去实现接口中的抽象方法：run()
 *  3，创建实现类的对象
 *  4，将实现类的对象作为参数传到Thread类的构造器中，创建Thread类的对象
 *  5，通过Thread类的对象调用start()方法
 *
 *  比较两种创建线程的方式
 *      开发中，优先选择实现Runnable接口的方式
 *      原因：
 *          1，实现的方式没有类的单继承的局限性
 *          2，实现方式更适合多个对象共享数据的情况
 *
 *  相同点：
 *      两种方法都要重写run方法，将线程要线程要做的工作在run方法中实现
 */
public class ThreadCreatMethod02 {
    public static void main(String[] args) {
        MyThread02 myThread02=new MyThread02();

        Thread thread=new Thread(myThread02);
        thread.setName("子线程");
        thread.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            if(i==10) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
class MyThread02 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }
}
