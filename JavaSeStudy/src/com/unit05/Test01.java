package com.unit05;

/**
 * @author cj
 * @create 2020-10-01 16:32
 */
public class Test01 {
    public static void main(String[] args) {
        A a =new A();
        a.show();//Class A: a=1 d=2.0
        A b=new B();
        b.show();//Class A: a=1 d=2.0    Class B: a=3.0 d=Java program
    }
}
class A {
    int a = 1;
    double d = 2.0;

    void show() {
        System.out.println("Class A: a=" + a + "\td=" + d);
    }
}

class B extends A {
    float a = 3.0f;
    String d = "Java program.";

    void show() {
        super.show();
        System.out.println("Class B: a=" + a + "\td=" + d);
    }
}