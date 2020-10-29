package com.unit08.threads.comunication;

/**
 * @author cj
 * @create 2020-10-25 20:07
 *
 * 线程通信的例子：使用两个线程打印1-100，两个线程交替打印
 *
 * 涉及到三个方法：
 *  wait()：一旦执行此方法，当前线程陷入阻塞状态，并且释放同步监视器
 *  notify()：一旦执行此方法，就唤醒一个阻塞态的线程，如果有多个线程被阻塞，就唤醒优先级最高的
 *  notifyAll()：一旦执行此方法，就会唤醒所有阻塞态的线程
 *
 *  说明：
 *      1，wait(), notify(), notifyAll() 必须使用在同步代码块或同步方法中
 *      2，wait(), notify(), notifyAll() 三个方法的调用者，必须是同步监视器，否则会报错
 *      3，wait(), notify(), notifyAll() 三个方法是定义在Object类中的，所有的类都有该方法（继承性）
 *
 *  面试题：
 *      sleep()方法和wait()方法的异同
 *      同：都会使线程陷入阻塞状态
 *      异：1，sleep()方法属于Thread类，wait()类属于Object类
 *          2，调用要求不同：sleep()可以在任何需要的场景下调用，wait()必须在同步代码块或同步方法中调用
 *          3，如果两者都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *          4，sleep()方法是阻塞一定时间后自动释放
 *              wait()方法阻塞后需要其他方法来释放
 *
 *
 */
class Message01 implements Runnable{
    private int num=1;

    @Override
    public void run() {
        while (true){

            synchronized (this){
                notify();
                if(num<=100){

                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }

        }

    }
}
public class MessageTest01 {
    public static void main(String[] args) {
        Message01 mg=new Message01();
        Thread t1=new Thread(mg);
        Thread t2=new Thread(mg);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
