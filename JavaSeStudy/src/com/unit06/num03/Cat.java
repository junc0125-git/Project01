package com.unit06.num03;

/**
 * @author cj
 * @create 2020-10-07 17:32
 *
 * 1）动物类Animal包含了抽象方法  abstract void shout()；
 * 2）Cat类继承了Animal，并实现方法shout，打印“猫会喵喵叫”
 * 3）Dog类继承了Animal，并实现方法shout，打印“狗会汪汪叫”
 * 4）在测试类中实例化对象Animal a1 =new  Cat(),并调用a1的shout方法
 * 在测试类中实例化对象Animal a2 =new  Dog(),并调用a2的shout方法
 */
public class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}
