package com.unit06.num04;

/**
 * @author cj
 * @create 2020-10-07 19:35
 *
 * 定义一个抽象类Person，有name,age,sex三个属性，创建构造函数，给这三个属性赋值，
 *  * 重写打印描述信息方法，打印三个属性值；
 *  * 这个类中有两个抽象方法work和hello；定义两个子类Teacher，Student；
 *  * 教师的work实现是：教书育人，hello实现是：“同学好”；
 *  * 学生的work实现是：认真学习，hello实现是“老师好”。
 */
public class Teacher extends Person{
    public Teacher() {
        super();
    }

    public Teacher(String name, int age, String sex) {
        super(name, age, sex);
    }

    @Override
    public void work() {
        System.out.println("教书育人");
    }

    @Override
    public void hello() {
        System.out.println("同学好");
    }
}
