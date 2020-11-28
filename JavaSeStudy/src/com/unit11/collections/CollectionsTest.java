package com.unit11.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *Collections：操作集合的工具类
 *      （注：操作数组的工具类：Arrays）
 *
 * Collections:操作Collection(list和set)、Map的工具类
 *
 *      Collections 是一个操作 Set、List 和 Map 等集合的工具类
 *      Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 *          还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 *
 * 面试题：Collection 和 Collections的区别？
 *          Collection：是一个集合接口
 *          Collections:操作Collection(list和set)、Map的工具类
 *
 *
 * @author shkstart
 * @create 2019 下午 4:19
 */
public class CollectionsTest {

/*
    排序操作：（均为static方法）
        reverse(List)：反转 List 中元素的顺序
        shuffle(List)：对 List 集合元素进行随机排序
        sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换，依据索引交换

    查找、替换
        Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        Object min(Collection)
        Object min(Collection，Comparator)
        int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        void copy(List dest,List src)：将src中的内容复制到dest中
        boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

 */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
        //原因：dest的size不能小于list的size   size: 元素的个数
//        List dest = new ArrayList();//初始元素个数为0   底层会创建一个默认长度为10的数组，
//                                                          但是size代表的不是数组长度，而是添加的元素个数
//        Collections.copy(dest,list);
        //正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size();
        //void copy(List dest,List src)：将src中的内容复制到dest中
        Collections.copy(dest,list);
        System.out.println(dest);


        /*
        将线程不安全的转为线程安全的
            Collections 类中提供了多个 synchronizedXxx() 方法，
            该方法可使将指定集合包装成线程同步的集合，从而可以解决
            多线程并发访问集合时的线程安全问题
         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);

        System.out.println(list);
        System.out.println(frequency);

    }

}
