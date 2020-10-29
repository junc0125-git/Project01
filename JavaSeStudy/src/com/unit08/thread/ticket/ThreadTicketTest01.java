package com.unit08.thread.ticket;

/**
 * @author cj
 * @create 2020-10-24 21:34
 * <p>
 * 例子：三个窗口：卖100张票，使用Runnable接口方式来实现
 *
 * 1，存在线程安全问题
 * 2，原因：当多个线程共享某一数据时，其中一个线程在处数据的过程中，有其他线程也对数据进行处理
 * 3，解决方法：当一个线程 a 在处理数据的过程中，其他线程不能操作该数据，直到线程 a 完成对数据的处理。在此过程中
 *          即使线程 a 发生阻塞，其他线程也必须等待。
 * 4，在java中我们采用同步机制来解决线程安全问题。
 *      方法一：同步代码块
 *          synchronized (同步监视器){
 *              //同步代码，即对共享资源进行操作的代码
 *          }
 *          解释：1，共享资源：多个线程共同操作的对象
 *                2，同步监视器，俗称：锁。任何一个类的对象都可以充当锁。
 *                   要求：多个线程必须共用一把锁。
 *           补充：在使用Runnable接口创建多线程的方式中，可以用this来做同步监视器
 *
 *      方法二：同步方法
 *
 * 5，同步机制：
 *          好处：解决了线程安全问题
 *          局限性：处理数据的过程中每个线程独占同步代码块，相当于单线程模式，效率低。
 */

class ThreadTicket01 implements Runnable {

    //    private static int ticket = 100;
    private int ticket = 100;//此处可以不用static，因为三个子线程用的是同一个对象参数
    //Object obj=new Object();//公共锁：任何一个类的对象都可以充当锁。

    @Override
    public void run() {
        while (true) {
            //synchronized (obj){
            synchronized (this){//this：表示当前类的对象，又因为用的是Runnable方式创建线程，所以this对象是所有线程共有的
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖出了" + "第" + ticket + "张票！");
                    ticket--;
                } else {
                    break;
                }
            }


        }
    }
}

public class ThreadTicketTest01 {
    public static void main(String[] args) {
        ThreadTicket01 ticket = new ThreadTicket01();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

