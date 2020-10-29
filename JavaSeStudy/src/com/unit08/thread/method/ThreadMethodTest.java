package com.unit08.thread.method;

/**
 * @author cj
 * @create 2020-10-23 20:32
 * <p>
 * 常用的Thread方法
 * 1，start()方法，用来启动线程，并且执行当前线程的run方法
 * 2，run()方法，通常需要重写，将创建的线程要执行的操作声明在此方法中
 * 3，currentThread()方法，静态方法，返回当前正在执行的线程
 * 4，getName()方法，获取当前线程的名字
 * 5，setName()方法，设置当前线程的名字，线程创建好对象后，手动调用该方法给线程命名
 * 6，yield()方法，释放当前线程对cpu的占有权
 * 7，join()方法，在线程 a 中调用线程 b 的join方法，此时线程 a 进入阻塞状态，直到线程 b 执行完成后，
 *      线程 a 才结束阻塞状态。
 * 8，stop()方法，已过时，不推荐使用，执行此方法时，强制结束当前线程
 * 9，sleep(XXX ms)方法，执行此方法时，当前线程阻塞xxx毫秒
 * 10，isAlive()方法，判断当前线程是否还存活。  返回boolean型
 *
 * 线程优先级
 * 1，
 * MAX_PRIORITY: 10
 * MIN_PRIORITY: 1
 * NORM_PRIORITY: 5 --> 默认优先级
 *2，如何获取和设置当前线程的优先级
 *      getPriority(): 获取线程的优先级
 *      setPriority(int p)：设置线程优先级
 *      优先级高只是有更大的概率获取执行机会，并不一定会先执行
 */
public class ThreadMethodTest {
    public static void main(String[] args){
        MyThreadMethod method = new MyThreadMethod("子线程");//用构造方法给线程命名
        //通过setName方法给线程命名
        // method.setName("线程1");

        //设置线程的优先级（在线程start之前设置，否则没作用）
        method.setPriority(Thread.MAX_PRIORITY);
        method.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
            /*if(i==20) {
                try {
                    method.join();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

        }
    }
}

class MyThreadMethod extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
            /*if(i%20==0) {
                *//*try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*//*
            }*/
                //yield();
        }
    }

    public MyThreadMethod(String name) {
        super(name);
    }
}
