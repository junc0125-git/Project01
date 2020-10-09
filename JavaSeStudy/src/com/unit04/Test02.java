package com.unit04;

/**
 * @author cj
 * @create 2020-10-01 16:06
 */

public class Test02 {
    int a;
    int b;
    public void f(){
        a = 0;
        b = 0;
        int[] c = {0};
        g(b,c);//此时b传的是形参过去，值不改变
        System.out.println(a + " " + b + " " + c[0]);//1 0 1  a是类的属性
    }
    public void g(int b, int[] c){
        a = 1;
        b = 1;
        c[0] = 1;
    }
    public static void main(String[] args) {
        Test02 t = new Test02();
        t.f();
    }
}