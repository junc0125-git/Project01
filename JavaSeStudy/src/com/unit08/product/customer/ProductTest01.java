package com.unit08.product.customer;

/**
 * @author cj
 * @create 2020-10-27 10:37
 * <p>
 * 自己写生产者消费者问题
 * <p>
 * 经典例题：生产者/消费者问题
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 * <p>
 * 分析：
 * 1，是否有多线程？ 是
 * 再生产者生产的过程中消费者可以消费
 * 2，是否有共享数据？  是
 * 生产者和消费者通过同一店员操作产品
 * 3，如何解决线程安全问题？   三种方法
 * 同步机制：同步代码块，同步方法
 * lock锁 -->  JDk 5.0新增
 * 4，是否涉及线程通信？ 是
 */
class Clerk01 {
    private int produceCount = 0;


    public synchronized void productProduce() {

        if (produceCount < 20) {
            produceCount++;

            System.out.println(Thread.currentThread().getName() + ":生产了第" + produceCount + "个产品");
            notify();
        } else {
            //让线程阻塞
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void customeProduce() {

        if (produceCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":消耗了第" + produceCount + "个产品");
            produceCount--;
            notify();
        } else {
            //让线程阻塞
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Productor01 extends Thread {
    private Clerk01 clerk01;

    public Productor01(Clerk01 clerk01) {
        this.clerk01 = clerk01;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产...");
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            clerk01.productProduce();
        }
    }
}

class Customer01 extends Thread {
    private Clerk01 clerk01;

    public Customer01(Clerk01 clerk01) {
        this.clerk01 = clerk01;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消耗...");
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            clerk01.customeProduce();
        }
    }
}

public class ProductTest01 {
    public static void main(String[] args) {
        Clerk01 clerk01 = new Clerk01();
        Productor01 p1 = new Productor01(clerk01);
        p1.setName("生产者1");

        Customer01 c1 = new Customer01(clerk01);
        c1.setName("消费者1");
        Customer01 c2 = new Customer01(clerk01);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();


    }
}
