package com.unit06.num05;

/**
 * @author cj
 * @create 2020-10-07 20:00
 *
 * 定义Shape抽象类，包含私有属性color，创建构造器为color赋值；
 * 包含计算周长的方法celPerimeter();
 * 定义子类Triangle， 包含三边；
 * 定义子类Circle，包含半径radius；
 * 子类分别实现父类的计算周长功能。
 */
public abstract class Shape {
    private String color;//颜色

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public abstract double celPerimeter();
}
