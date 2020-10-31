package com.unit09.compare_class.own;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cj
 * @create 2020-10-29 16:53
 *
 * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 *           但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *
 *        如何实现比较对象的大小？
 *          使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *      Comparable接口：长久性   自然排序
 *          一个类一旦实现了Comparable接口，重写了该接口的copareTo()方法，以后该类的对象都可以比较大小
        Comparator接口：临时性  定制排序
            属于临时性的比较。需要完成一个特定的排序时，临时创建使用一次
 *
 */
public class CompareTest {

    /////////////////////////////////*******  Comparable接口的使用   ************ //////////////////////////////////
    /*
    为什么要实现Comparable接口？    sort()函数在排序过程中会根据参数类型调用对应类的compareTo()方法来比较大小

    Comparable接口的使用举例：  自然排序：类只需要重写了Comparable接口的compareTo(obj)方法，
                                        其他的不用管了，sort()方法会自动处理
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3. 重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
       在compareTo(obj)方法中指明如何排序（即根据对象的哪些属性排序）
       注：可能根据对象的多个属性进行多重排序（例：先根据价格排，价格相同在根据名称排）
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //sort()函数在排序过程中会根据参数类型调用对应类的compareTo()方法来比较大小
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        //sort()函数在排序过程中会根据参数类型调用对应类的compareTo()方法来比较大小
        //对于自定义类，如果需要排序，需要实现接口Comparable，重写compareTo(obj)方法
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    /////////////////////////////////*******  Comparator接口的使用   ************ //////////////////////////////////
    /*
    Comparator接口的使用：定制排序  临时性的
    1.背景：
        当元素的类型没有实现Comparable接口而又不方便修改代码，  -->  没实现Comparable接口，且不方便修改代码
    或者实现了Comparable接口的排序规则不适合当前的操作，    -->   实现了Comparable接口，但排序规则不适合
    那么可以考虑使用 Comparator 的对象来排序

    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：  -->     前 - 后  ？ 用结果判断大小
        如果方法返回正整数，则表示o1大于o2；  -->   正：  o1 > o2
        如果返回0，表示相等；                -->    0:   o1 = o2
        返回负整数，表示o1小于o2。           -->   负：  o1 < o2
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};

        //调用的是sort()的重载函数，此函数有两个参数，
        // 第一个参数是待排序的对象数组，第二个参数是Comparator接口的匿名实现类对象
        Arrays.sort(arr,new Comparator(){//创建了接口的匿名实现类对象
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {//重写compare()方法
                if(o1 instanceof String && o2 instanceof  String){
                    String s1 = (String) o1;//可能是子类，所以要强转一下
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);//直接调用String类的compareTo方法，返回值是int型
                                                //前加 负号(-) 改变了排序方向  小->大  ---->>>  大->小
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}