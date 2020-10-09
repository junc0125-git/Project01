package com.day01;

/**
 * @author cj
 * @create 2020-09-26 10:39
 * <p>
 * Cylinder (圆柱)
 * * -length:double
 * * Cylinder(): 构造器,将length属性初始化为1
 * * +setLength(double length):void
 * * +getLength():double
 * * +findVolume() :double 计算圆柱体积
 */
public class Cylinder extends Circle {
    private double length;//圆柱的长度

    public Cylinder() {
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume() {
        return Math.PI * getRadius() * getRadius() * length;
    }
}
