package com.unit08.thread.ticket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cj
 * @create 2020-10-25 15:11
 *
 * 解决线程安全问题方法三：lock锁 -->  JDk 5.0新增
 *
 *  面试题：synchronized 和 lock 区别
 *      同：两者都可以解决线程安全问题
 *      异：synchronized 执行完相应的同步代码块之后，自动的释放同步监视器
 *          lock 需要手动的启动同步（lock()），手动的结束同步（unlock()）
 */
public class ThreadLockTest {
    public static void main(String[] args) {
        ThreadLock lock=new ThreadLock();

        Thread t1=new Thread(lock);
        Thread t2=new Thread(lock);
        Thread t3=new Thread(lock);

        t1.start();
        t2.start();
        t3.start();

    }
}
class ThreadLock implements Runnable{
    private int ticket=100;

    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {

                //调用lock方法加锁
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}