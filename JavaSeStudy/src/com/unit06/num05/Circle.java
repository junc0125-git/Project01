package com.unit06.num05;

/**
 * @author cj
 * @create 2020-10-07 20:08
 *
 * 定义Shape抽象类，包含私有属性color，创建构造器为color赋值；
 *  * 包含计算周长的方法celPerimeter();
 *  * 定义子类Triangle， 包含三边；
 *  * 定义子类Circle，包含半径radius；
 *  * 子类分别实现父类的计算周长功能。
 */
public class Circle extends Shape{
    private double radius;//半径

    public Circle() {
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double celPerimeter() {
        return 2*Math.PI*radius;
    }
}
