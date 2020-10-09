package com.unit05.num04;

/**
 * @author cj
 * @create 2020-10-03 15:42
 *
 * 4,,创建一个汽车类（Car）
 * （1）为其定义两个属性：颜色和型号。每个属性都使用private进行封装，为每个属性设置set、get方法。
 * （2）为该类创建两个构造方法。第一个为无参的构造方法。第二个为带参构造方法
 * （3）重写toString方法，通过toString输出汽车信息。
 * （4）重写equals方法，如果汽车的颜色和型号相同就认为是同一辆车。
 * （5）实例化两个对象，输出两个对象的信息，比较两个对象是否是同一个对象。
 */
public class Test {
    public static void main(String[] args) {
        Car car1=new Car("red","奥迪");
        Car car2=new Car("black","宝马");
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car1.equals(car2));
    }
}
