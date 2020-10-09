package com.unit04;

/**
 * @author cj
 * @create 2020-09-29 14:58
 *
 * 编程创建一个Box类，在其中定义三个变量表示一个立方体的长、宽和高，定义一个方法求立方体的体积。
 * 创建一个对象，求给定尺寸的立方体的体积。
 * （提供无参的构造器和一个有参的构造器）
 */
public class BoxTest {
    public static void main(String[] args) {
//        private double length;//局部变量不能用权限修饰符修饰
        Box box = new Box(1,2,3);
        box.getVolume();

    }

}

class Box{
    //length, width and height
    private double length;//长
    private double width;//宽
    private double height;//高

    public Box() {
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void getVolume(){
        System.out.println(length*width*height);
    }
}