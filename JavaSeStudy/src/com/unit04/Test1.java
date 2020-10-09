package com.unit04;

/**
 * @author cj
 * @create 2020-09-30 18:10
 */
public class Test1 {

    public static void main(String[] args) {
        new A(new B());//BAAB
    }
}
class A{
    public A(){
        System.out.println("A");
    }
    public A(B b){
        this();
        System.out.println("AB");
    }
}
class B{
    public B(){
        System.out.println("B");
    }
}