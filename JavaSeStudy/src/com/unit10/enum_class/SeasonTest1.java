package com.unit10.enum_class;

/**
 * 方式二：jdk5.0以及之后
 * 使用enum关键字定义枚举类   -->  enum替代了class的功能
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * 三、Enum类中的常用方法：
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：根据枚举类对象名称来获取枚举类对象。要求字符串必须是枚举类对象的“名字”。如
 *                          不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *     情况一：实现接口，在enum类中实现抽象方法
 *     情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 * @author shkstart
 * @create 2019 上午 10:35
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称   此时调用的toString()是属于父类Enum的，用来返回枚举对象名称
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("****************");

        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);//直接写对象名，默认调用父类的toString()方法
            values[i].show();
        }
        System.out.println("****************");

        //查看线程有哪些状态
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        //用来获取一个枚举对象
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
        winter.show();
    }
}

interface Info{
    void show();
}

//使用enum关键字定义枚举类
enum Season1 implements Info{//实现接口

    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    //类型，new...都省略了，直接写对象名称，如果没有属性的话，小括号都可以省略，只写对象名称，用逗号隔开
    //情况二：让枚举类的对象分别实现接口中的抽象方法
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
//    //4.其他诉求1：提供toString()
//
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

//      情况一：实现接口，在enum类中实现抽象方法
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}