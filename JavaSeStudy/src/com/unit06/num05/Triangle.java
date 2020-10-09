package com.unit06.num05;

/**
 * @author cj
 * @create 2020-10-07 20:03
 *
 * 定义Shape抽象类，包含私有属性color，创建构造器为color赋值；
 *  * 包含计算周长的方法celPerimeter();
 *  * 定义子类Triangle， 包含三边；
 *  * 定义子类Circle，包含半径radius；
 *  * 子类分别实现父类的计算周长功能。
 */
public class Triangle extends Shape{
    private double c1;
    private double c2;
    private double c3;
    public Triangle() {
    }

    public Triangle(String color, double c1, double c2, double c3) {
        super(color);
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    @Override
    public double celPerimeter() {
        return c1+c2+c3;
    }


}
