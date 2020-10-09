package com.unit05.num07;

/**
 * @author cj
 * @create 2020-10-03 16:55
 */
class A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }
    // public int getA(){
    // return a;
    // }
}

public class PersonTest {

    public static void main(String[] args) {
        A c = new B();

        c.setA(5);

        System.out.println(c.getA());//0
    }
}
