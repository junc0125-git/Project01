package com.day01;

/**
 * @author cj
 * @create 2020-09-26 10:21
 * <p>
 * 3. 根据下图实现类。在CylinderTest类中创建Cylinder类的对象，设置圆
 * 柱的底面半径和高，并输出圆柱的体积。
 * Circle (圆) -radius :double
 * Circle(): 构造器,将radius属性初始化为1
 * +setRadius(double radius) : void
 * +getRadius(): double
 * +findArea():double 计算圆的面积
 *
 * Cylinder (圆柱)
 * -length:double
 * Cylinder(): 构造器,将length属性初始化为1
 * +setLength(double length):void
 * +getLength():double
 * +findVolume() :double 计算圆柱体积
 */
public class Circle {
    private double radius;//圆的半径

    public Circle() {
        radius = 1;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double findArea(){
        return Math.PI*radius*radius;
    }

}
