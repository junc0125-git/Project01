package com.unit04;

/**
 * @author cj
 * @create 2020-09-28 19:08
 * <p>
 * 编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
 * 类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。
 * 在另一个StudentTest类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用结果打印输出。
 */
public class StudentTest {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("小明");
        st.setGender("男");
        st.setAge(18);
        st.setId(001);
        st.setScore(88.9);
        String info = st.say();
        System.out.println(info);

    }
}

class Student {
    //    编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
    private String name;
    private String gender;
    private int age;
    private int id;
    private double score;

    public Student() {
    }

//    声明一个say方法，返回String类型，方法返回信息中包含所有属性值。

    public String say() {
        return "name:" + getName() + "  gender:" + getGender() + "  age:" + getAge() + "  id:" + getId() + "  sorce:" + getScore();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}