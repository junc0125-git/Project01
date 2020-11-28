package com.unit11.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1. Set接口的框架：
 *
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                                      对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
 *              |----TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 *
 *  1. Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *      因为set没有索引
 *
 *  2. 要求：向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类一定要重写hashCode()和equals()
 *     要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象（内容完全相同）必须具有相等的散列码
 *      重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field（属性），都应该用来计算 hashCode 值。
 *
 *
 * 注： equals()方法只能用来比较两个同类型（或者父子类的关系）的对象
 *
 *
 * @author shkstart
 * @create 2019 下午 3:40
 */
public class SetTest {
    /*
    一、Set：存储无序的、不可重复的数据
    以HashSet为例说明：  不能按照加入时的顺序遍历
    1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。

    2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。

    二、添加元素的过程：以HashSet为例：  底层结构既有数组又有链表：hash值对应数组同一位置的，用链表串起来
        我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
        数组此位置上是否已经有元素：
            如果此位置上没有其他元素，则元素a添加成功。 --->情况1
            如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
                如果hash值不相同，则元素a添加成功。--->情况2
                如果hash值相同，进而需要调用元素a所在类的equals()方法：
                       equals()返回true,元素a添加失败
                       equals()返回false,则元素a添加成功。--->情况3

        对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
        jdk 7 :元素a放到数组中，指向原来的元素。  头插法
        jdk 8 :原来的元素在数组中，指向元素a      尾插法
        数组中一直存储的都是链表的头

        HashSet底层：数组+链表的结构。
                    底层结构既有数组又有链表：hash值对应数组同一位置的，用链表串起来
                        （注：不同hash值也可能映射到同一位置
                        如果类没有重写 hashCode()函数，则可能两个对象的内容完全相同，但hash值却不同，
                        然后映射到数组不同位置，最终重复添加
                        所以一定要重写hashCode()函数，重写后，内容完全相同的两个对象hash值一定相同
                        （注：内容不同的对象hash值也可能相同，故hash值相同的情况下，还要用equals()函数判断一下）
    */
    //HashSet的使用
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
        LinkedHashSet的使用：
            LinkedHashSet作为HashSet的子类，在HashSet的基础上，在添加数据的同时，
              每个数据还维护了两个引用，记录此数据前一个数据和后一个数据。
              因此其可按照加入时的顺序遍历
        优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
