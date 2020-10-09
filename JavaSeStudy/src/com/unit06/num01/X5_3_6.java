package com.unit06.num01;

/**
 * @author cj
 * @create 2020-10-07 16:44
 * <p>
 * * （4）X5_3_6.java文件，在该文件中定义主类X5_3_6，该类在默认包中，其中包含主方法main()，
 * 在主方法中创建两个圆类对象cir1和cir2，具体尺寸自己确定，并显示圆的面积和周长；
 * 再创建两个圆柱体类的对象cy1和cy2，具体尺寸自己确定，
 * 然后分别显示圆柱体cy1和cy2的底圆的面积和周长以及它们各自的体积和表面积。
 * * 【编程分析】本题主要考察接口、包、继承、封装等问题
 */
public class X5_3_6 {
    public static void main(String[] args) {
        Circle cir1 = new Circle(10);
        Circle cir2 = new Circle(100);
        Cylinder cy1=new Cylinder(10,10);
        Cylinder cy2=new Cylinder(20,20);
        System.out.println("cir1.area:"+cir1.area());
        System.out.println("cir1.perimeter:"+cir1.perimeter());
        System.out.println("cir2.area:"+cir2.area());
        System.out.println("cir2.perimeter:"+cir2.perimeter());
        System.out.println("cy1.lowArea:"+cy1.lowArea());
        System.out.println("cy1.perimeter:"+cy1.perimeter());
        System.out.println("cy1.area :"+cy1.area());
        System.out.println("cy1.volume:"+cy1.volume());
        System.out.println("cy2.lowArea:"+cy2.lowArea());
        System.out.println("cy2.perimeter:"+cy2.perimeter());
        System.out.println("cy2.area :"+cy2.area());
        System.out.println("cy2.volume:"+cy2.volume());


    }
}
