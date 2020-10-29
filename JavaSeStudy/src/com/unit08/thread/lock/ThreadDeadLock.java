package com.unit08;

/**
 * @author cj
 * @create 2020-10-25 14:50
 *
 * 演示线程的死锁问题
 */
public class ThreadDeadLock {
    public static void main(String[] args) {
        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("a");
                    System.out.println(s1);
                    System.out.println(s2);
                    s2.append("1");
                    System.out.println(s1);
                    System.out.println(s2);
                    /*synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }*/
                }

            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s2.append("3");
                    System.out.println(s1);
                    System.out.println(s2);
                    s1.append("c");
                    System.out.println(s1);
                    System.out.println(s2);
                    /*synchronized (s1){
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }*/
                }
            }
        }).start();
    }
}
