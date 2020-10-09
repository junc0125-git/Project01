package com.unit04.program01;

/**
 * @author cj
 * @create 2020-09-28 19:25
 */
public class Wife {
    private String name;
    private int age;
    private Husband husband;

    public Wife(String name, int age, Husband husband) {
        this.name = name;
        this.age = age;
        this.husband = husband;
    }

    public String getInfo(){
        return "name:"+getName()+" age:"+getAge()+" husband’s name:"+getHusband().getName()+"husband’s age:"+getHusband().getAge();
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

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
