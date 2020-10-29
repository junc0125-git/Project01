package com.unit08.thread.ticket;

/**
 * @author cj
 * @create 2020-10-25 10:38
 * <p>
 * 例子：100张票，三个窗口卖  --->   存在线程安全问题
 * *
 * * 解决： 使用同步方法来解决 Thread子类创建多线程中的线程安全问题
 */
public class ThreadTicketTest03 {
    public static void main(String[] args) {
        ThreadTicket03 t1=new ThreadTicket03();
        ThreadTicket03 t2=new ThreadTicket03();
        ThreadTicket03 t3=new ThreadTicket03();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadTicket03 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
            if(ticket<=0)
                break;
        }
    }

    private static synchronized void show(){//同步监视器：ThreadTicket03.class
        // private synchronized void show(){//同步监视器：this，每个对象都独自拥有
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+":"+"卖出了第"+ticket+"张票");
            ticket--;
        }
    }
}