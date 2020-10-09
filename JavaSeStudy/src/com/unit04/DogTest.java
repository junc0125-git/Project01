package com.unit04;

import java.util.Objects;

/**
 * @author cj
 * @create 2020-09-29 15:17
 *
 * 设计一个Dog类，有名字、颜色和年龄属性，定义构造器初始化这些属性
 * ，定义输出方法show()显示其信息。
 * 提供无参的构造器和一个有参的构造器
 */
public class DogTest {
    public static void main(String[] args) {
        Dog dog =new Dog("晃晃","黄色",3);
        dog.show();

    }
}

class Dog{
    private String name;
    private String color;
    private int age;

    public Dog() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return age == dog.age &&
                Objects.equals(name, dog.name) &&
                Objects.equals(color, dog.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, age);
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

//    定义输出方法show()显示其信息。
    public void show(){
        System.out.println("name: "+name+"  color: "+color+"  age: "+age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}