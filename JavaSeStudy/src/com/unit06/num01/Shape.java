package com.unit06.num01;

/**
 * @author cj
 * @create 2020-10-07 16:30
 *
 * <p>
 * 1,,编一个程序，包含以下文件
 * （1）Shape.java文件，在该文件中定义接口类Shape，该接口在shape包中。
 * 属性：PI。
 * 接口：求面积的方法area()。
 * （2）Circle.java文件，在该文件中定义圆类Circle，该类在circle包中，实现Shape接口类。
 * 属性：圆半径radius。
 * 方法：构造器；实现求面积方法area()；求周长方法perimeter()。
 * （3）Cylinder.java文件，在该文件中定义圆柱体类Cylinder，该类在cylinder包中，继承圆类。
 * 属性：圆柱体高度height。
 * 方法：构造器；求表面积方法area()；求体积方法volume()。
 * （4）X5_3_6.java文件，在该文件中定义主类X5_3_6，该类在默认包中，其中包含主方法main()，在主方法中创建两个圆类对象cir1和cir2，具体尺寸自己确定，并显示圆的面积和周长；再创建两个圆柱体类的对象cy1和cy2，具体尺寸自己确定，然后分别显示圆柱体cy1和cy2的底圆的面积和周长以及它们各自的体积和表面积。
 * 【编程分析】本题主要考察接口、包、继承、封装等问题。
 */
public interface Shape {
    double PI = 3.14;
    double area();
}
