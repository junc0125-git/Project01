package com.unit06.num01;

/**
 * @author cj
 * @create 2020-10-07 16:34
 *
 * 2）Circle.java文件，在该文件中定义圆类Circle，该类在circle包中，实现Shape接口类。
 *  * 属性：圆半径radius。
 *  * 方法：构造器；实现求面积方法area()；求周长方法perimeter()。
 */
public class Circle implements Shape{
    private double radius;//半径

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

    public double perimeter(){
        return 2*PI*radius;
    }
}
