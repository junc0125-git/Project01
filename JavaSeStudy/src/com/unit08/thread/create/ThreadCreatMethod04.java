package com.unit08.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cj
 * @create 2020-10-27 8:38
 *
 * 创建线程的方式四：是用线程池
 *
 * 背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，
 * 对性能影响很大。
 *
 * 思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完
 * 放回池中。可以避免频繁创建销毁、实现重复利用。类似生活中的公共交
 * 通工具。
 *
 * 好处：
 *  提高响应速度（减少了创建新线程的时间）
 *  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  便于线程管理：
 *       corePoolSize：核心池的大小
 *       maximumPoolSize：最大线程数
 *       keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *      ...
 *
 * 线程池相关API
 *   JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors
 *   ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor
 *       void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行
 *  Runnable
 *       <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行
 *  Callable
 *       void shutdown() ：关闭连接池
 *   Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 *       Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
 *       Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
 *       Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
 *       Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运
 *  行命令或者定期地执行。
 */
class MyThread04 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}

class MyThread04_01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}

public class ThreadCreatMethod04 {
    public static void main(String[] args) {

        //1，提供指定线程数量的线程池  注：ExecutorService是一个接口
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性
//        service.  接口的属性都是常量，不可更改，故要先把接口转换为实现类
//        System.out.println(service.getClass());//查看一下service所属的类：class java.util.concurrent.ThreadPoolExecutor
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);

        //2，执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象作为参数
//        service.submit();//适用于实现Callable接口的线程类
//        service.execute();//适用于实现Runnable接口的线程类
        service.execute(new MyThread04());
        service.execute(new MyThread04_01());

        //关闭连接池
        service.shutdown();

    }
}
