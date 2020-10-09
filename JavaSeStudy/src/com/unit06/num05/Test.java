package com.unit06.num05;

/**
 * @author cj
 * @create 2020-10-07 20:09
 */
public class Test {
    public static void main(String[] args) {
        Shape circle=new Circle("黄色",10);
        Shape triangle=new Triangle("红色",10,10,10);
        System.out.println("圆的周长："+circle.celPerimeter());
        System.out.println("三角形的周长："+triangle.celPerimeter());
    }
}
