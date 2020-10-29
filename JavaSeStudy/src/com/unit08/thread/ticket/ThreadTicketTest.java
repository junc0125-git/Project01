package com.unit08;

/**
 * @author cj
 * @create 2020-10-23 23:31
 *
 * 题目：100张票，在三个窗口卖  -->  使用创建Thread子类方式
 *
 * 存在线程安全问题，待解决
 *
 * 使用同步代码块解决线程安全问题
 *
 */
class ThreadTicket extends Thread{
    private static int ticket=100;//票数
//    private static Object obj=new Object();//同步监视器，俗称锁，必须是公共的
    @Override
    public void run() {
        while(true){
//            synchronized (obj){
            synchronized (ThreadTicket.class){//使用该类的对象作为同步监视器，因为类只加载一次，所以其是公共的
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+":卖出了第"+ticket+"张票");
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}

public class ThreadTicketTest {
    public static void main(String[] args) {
        ThreadTicket t1=new ThreadTicket();
        ThreadTicket t2=new ThreadTicket();
        ThreadTicket t3=new ThreadTicket();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}
