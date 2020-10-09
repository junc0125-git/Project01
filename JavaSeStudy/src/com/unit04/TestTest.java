package com.unit04;

/**
 * @author cj
 * @create 2020-10-01 15:40
 */
public class TestTest {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.method(5);
    }

}

class Test2 {
    int x = 12;

    public void method(int x) {
        x += x;
        System.out.println(x);
    }
}
