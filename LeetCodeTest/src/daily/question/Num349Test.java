package daily.question;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author cj
 * @create 2020-11-02 16:39
 *
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Num349Test {
    @Test
    public void test(){

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> setR=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            boolean b = set.contains(nums2[i]);
            if(b){
                setR.add(nums2[i]);
            }

        }
//        Object[] objects = setR.toArray();
        int[] array=new int[setR.size()];
        int i=0;
        Iterator iterator = setR.iterator();
        while (iterator.hasNext()) {
            array[i]=(int)iterator.next();
            i++;

        }
        return array;


    }

}
