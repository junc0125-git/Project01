package com.unit08.thread.ticket;

/**
 * @author cj
 * @create 2020-10-25 10:20
 *
 * 例子：100张票，三个窗口卖  --->   存在线程安全问题
 *
 * 解决： 使用同步方法来解决 Runnable接口创建多线程 中的线程安全问题
 */
public class ThreadTicketTest02 {
    public static void main(String[] args) {
        ThreadTicket02 ticket=new ThreadTicket02();

        Thread t1=new Thread(ticket);
        Thread t2=new Thread(ticket);
        Thread t3=new Thread(ticket);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class ThreadTicket02 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while(true){
            show();
            if(ticket<=0)
                break;
        }
    }
    private synchronized void show(){//同步监视器：this
            if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+":"+"卖出了第"+ticket+"张票");
                    ticket--;
                }

    }
}