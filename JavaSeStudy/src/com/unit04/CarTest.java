package com.unit04;

/**
 * @author cj
 * @create 2020-09-30 17:47
 *
 * 写一个汽车类：
 * 属性：品牌；车长；颜色；价格；
 * 创建五个对象：“捷达”，“宝马”，“劳斯莱斯”，“科鲁兹”，“迈锐宝”
 * 提供无参的构造器和一个有参的构造器
 */
public class CarTest {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0]=new Car();
        cars[0].setBrand("宝马");
        System.out.println(cars[0].getBrand());


    }
}
class Car{
    private String brand;
    private String length;
    private String color;
    private double price;

    public Car() {

    }

    public Car(String brand, String length, String color, double price) {
        this.brand = brand;
        this.length = length;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}