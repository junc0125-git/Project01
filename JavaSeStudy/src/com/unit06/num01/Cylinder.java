package com.unit06.num01;

/**
 * @author cj
 * @create 2020-10-07 16:31
 * <p>
 * 3）Cylinder.java文件，在该文件中定义圆柱体类Cylinder，该类在cylinder包中，继承圆类。
 * * 属性：圆柱体高度height。
 * * 方法：构造器；求表面积方法area()；求体积方法volume()。
 * * （4）X5_3_6.java文件，在该文件中定义主类X5_3_6，该类在默认包中，其中包含主方法main()，
 * 在主方法中创建两个圆类对象cir1和cir2，具体尺寸自己确定，并显示圆的面积和周长；
 * 再创建两个圆柱体类的对象cy1和cy2，具体尺寸自己确定，
 * 然后分别显示圆柱体cy1和cy2的底圆的面积和周长以及它们各自的体积和表面积。
 * * 【编程分析】本题主要考察接口、包、继承、封装等问题
 */
public class Cylinder extends Circle {
    private double height;//高

    public Cylinder() {
        super();
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double area() {
        return super.area() * 2 + super.perimeter() * height;
    }

    @Override
    public double perimeter() {
        return super.perimeter();
    }

    public double lowArea() {
        return super.area();
    }

    public double volume() {
        return super.area() * height;
    }
}
