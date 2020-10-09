package com.unit05.num05;

/**
 * @author cj
 * @create 2020-10-03 15:51
 *
 * 5，，编写一个Java应用程序，设计一个汽车类Vehicle，包含的属性有车轮个数wheels和车重weight。
 * 小车类Car是Vehicle的子类，其中包含的属性有载人数loader。卡车类Truck是Car类的子类，
 * 其中包含的属性有载重量payload。
 * （1）每个类都有构造方法进行属性初识化
 * （2）每个类都输出相关数据的toString方法
 * （3）使用Test类中的main方法定义各类初始化数据后台打印相关数据
 */
public class Truck extends Car{
    private double payload;//载重量

    public Truck() {
    }

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                '}'+super.toString();
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }
}
