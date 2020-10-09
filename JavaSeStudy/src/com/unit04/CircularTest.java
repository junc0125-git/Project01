package com.unit04;

/**
 * @author cj
 * @create 2020-09-29 15:06
 *
 * 定义一个圆类型
 * 提供显示圆周长功能的方法
 * 提供显示圆面积的方法
 * 提供无参的构造器和一个有参的构造器
 */
public class CircularTest {
    public static void main(String[] args) {
        Circular circular = new Circular();
        circular.setRadius(10);
        circular.getPerimeter();
        circular.getArea();


    }
}

class Circular{
    private double radius;//半径

    public Circular() {
    }

    public Circular(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void getPerimeter(){//输出周长
        System.out.println(2*Math.PI*radius);
    }

    public void getArea(){//输出面积
        System.out.println(Math.PI*radius*radius);
    }
}