package com.unit04.program01;

/**
 * @author cj
 * @create 2020-09-28 19:25
 *
 * 定义一个丈夫Husband类，有姓名、年龄、妻子属性
 * 定义一个妻子Wife类，有姓名、年龄、丈夫属性
 * 丈夫类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和他的妻子的姓名，年龄
 * 妻子类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和她的丈夫的姓名，年龄
 * 定义一个测试类，创建妻子和丈夫对象，然后测试
 */
public class Husband {
    private String name;
    private int age;
    private Wife wife;

    public Husband() {
    }

    public String getInfo(){
        return "name:"+getName()+" age:"+getAge()+" wife’s name:"+getWife().getName()+" wife’age:"+getWife().getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }


}
