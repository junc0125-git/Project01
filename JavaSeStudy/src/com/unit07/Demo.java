package com.unit07;

/**
 * @author cj
 * @create 2020-10-17 15:55
 */
public class Demo {
    public static void func() {
        try {
            throw new Exception();
            //System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {//BD
        try {
            func();
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
}