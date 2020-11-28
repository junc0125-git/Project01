package com.unit11.exer.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019 下午 3:33
 */
public class ListExer {
    /*
    可做笔试题：
        区分List中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
//        区分List中remove(int index)和remove(Object obj)
//        list.remove(2);//删除的是下标为2的元素
        list.remove(new Integer(2));//删除的是一个对象，其内容为2
    }

}
