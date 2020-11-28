package com.unit12.generic.use.self_define_use.class_interface_methods;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shkstart
 * @create 2019 上午 11:05
 *
 * 自定义泛型类
 *  当类中的某一个属性的类型不确定时，可以先使用泛型
 */
public class Order<T> {//用一个大写字母表示，一般用 T,E,V

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法     泛型方法：方法的返回值类型前加 <泛型标识>
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    /*
        静态方法中不能使用*类的泛型*。     因为类的泛型是在实例化时确定类型，而static修饰的结构是在类加载时而加载
        上述此时的静态方法并不是泛型方法，在类加载时就需要确定类型
        而静态的泛型方法特许在调用时才确定类型

        但是静态方法可以声明为泛型的，因为泛型方法是在调用时确定类型的

        总结：一个方法是不是泛型方法，与类的泛型没有任何关系


     */
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show(){
        //编译不通过
//        try{
//
//
//        }catch(T t){
//
//        }

    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E>  List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }
}
