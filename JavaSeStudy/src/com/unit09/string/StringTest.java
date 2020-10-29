package com.unit09.string;

import org.junit.Test;

/**
 * @author cj
 * @create 2020-10-27 14:49
 *
 * String 的使用
 */
public class StringTest {
/*
结论：
     常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
     只要其中有一个是变量，结果就在堆中
     如果拼接的结果调用intern()方法，返回值就在常量池中
 */
    @Test
    public void test4(){
        String s1="hello";
        String s2="word";
        String s3="helloword";
        String s4="hello"+"word";
        System.out.println(s3==s4);

        final String s5="hello";
        String s6=s5+"word";
        System.out.println(s3==s6);//true   final修饰后 s5 成为常量，而常量和常量的拼接结果在常量池

    }

    @Test
    public void test3(){
        String s1="hello";
        String s2="word";

        String s3="helloword";
        String s4="hello"+"word";
        String s5=s1+"word";
        String s6="hello"+s2;
        String s7=s1+s2;
        String s8=s1;
        System.out.println(s1==s8);//true
        String s9=s7;
        System.out.println(s9==s7);//true   赋值赋的是地址值

        String s10=s5.intern();
        System.out.println(s3==s10);//true  如果拼接的结果调用intern()方法，返回值就在常量池中

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s7);//false
        System.out.println(s4==s5);//false
        System.out.println(s5==s6);//false
        System.out.println(s6==s7);//false




    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
        String的实例化方式：
            方式一：通过字面量定义的方式
            方式二：通过new + 构造器的方式
                在堆空间中开辟新内存

             面试题：String name=new String("abc");方式创建对象，在内存中创建了几个对象？
                    两个：一个是堆空间中的new结构，另一个是方法区中字符串常量池存储的char[]数组："abc"
     */
    @Test
    public void test2(){
        String s1="javaEE";
        String s2="javaEE";
        String s3=new String("javaEE");
        String s4=new String("javaEE");

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1==s4);//false
        System.out.println(s3==s4);//false
        System.out.println(s1.equals(s3));//true
        System.out.println(s4.equals(s3));//true   String重写后的equals是比较两个字符串的值


    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
        String：字符串，使用一对 "" 引起来表示
        1，String 声明为final的，不可被继承
        2，String实现了Serializable接口：表示字符串是支持序列化的。
                实现了Comparable接口：表示String可比较大小的
        3，String内部定义了一个 final char[] value 数组，用来存储字符串数据
        4，String：代表不可变的字符序列。简称：不可变性
            体现：1，当对字符串重新赋值时，是新开辟内存区域存储值，而不是在原有的内存区域进行值修改。
                 2，当对现有的字符串进行连接操作时，也是重新开辟内存区域进行赋值，不能再原有的区域进行修改
                 3，当调用String的replace()方法修改指定字符或字符串时，也需要重新开辟内存区域赋值

        5，通过字面量的方式（区别于 new方式）给一个字符串赋值，此时的字符串值声明在方法区中字符串常量池中
        6，字符串常量池中不会存两个相同的字符串值
     */
    @Test
    public void test1(){

        String s1="abc";//字面量的定义方式
        String s2="abc";

        //   == ：对于引用类型，比较的是地址值
        System.out.println(s1==s2);//   true  原因：内存中的字符串常量池中已存有字符串"abc"，不会在新开辟地址存储”abc“了，
                                    //  而是直接将"abc"的地址给s2

        s2="Hello";
        System.out.println(s1);//abc
        System.out.println(s2);//Hello
        System.out.println(s1==s2);//false  重新开辟内存地址用来存储Hello

        String s3="abc";
        s3+="def";
        System.out.println(s1);
        System.out.println(s3);

        String s4="abc";
        String s5=s4.replace('b','m');//    s4的值并未改变，仅仅将修改后的字符串赋值给s5
        System.out.println(s4);//abc
        System.out.println(s5);//amc



//        System.out.println("HelloJunit!");
    }
}
