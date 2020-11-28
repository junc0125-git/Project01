package com.unit12.generic.use.self_define_use.class_interface_methods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019 上午 11:15
 */
public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类
    //由于子类在继承带泛型的父类时，父类指明了泛型类型，那么子类便不再是泛型类。


    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }


}
