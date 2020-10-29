package com.unit08.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author cj
 * @create 2020-10-26 20:52
 *
 * 创建线程的方式三：实现callable接口  -->  JDK5.0 新增
 *
 * 与使用Runnable相比， Callable功能更强大些
 *       相比run()方法，可以有返回值
 *       方法可以抛出异常
 *       支持泛型的返回值
 *       需要借助FutureTask类，比如获取返回结果
 *
 */
//1，创建一个实现Callable接口的实现类
class MyThread03 implements Callable {
    //2，重写call()方法，将线程需要实现的操作声明在call()方法中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }
}

public class ThreadCreatMethod03 {
    public static void main(String[] args) {

        //3，创建Callable接口实现类的对象
        MyThread03 myThread03=new MyThread03();

        //4，将此Callable接口实现类的对象作为参数传到FutureTask构造器中，并创建FutureTask类的对象
        FutureTask futureTask = new FutureTask(myThread03);

        //5，将此FutureTask类的对象作为参数传到Thread类的构造器中，创建Thread类的对象，并调用start()方法
        //FutureTask类也实现了runnable接口
        new Thread(futureTask).start();

        try {
            //6，获取Callable接口的实现类中重写call()方法的返回值，注意get()方法是属于FutureTask类
            //get()方法的返回值即为FutureTask构造器参数（callable接口实现类的对象）的call()方法返回值
            //get()方法不是必须的，仅仅是为了获取返回值的，如果不需要返回值，可以不写
            Object call = futureTask.get();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
