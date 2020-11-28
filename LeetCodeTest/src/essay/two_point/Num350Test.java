package essay.two_point;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cj
 * @create 2020-11-11 10:20
 *
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Num350Test {

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }

        //复制固定区间的数组
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        //判断是否为空
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)
            return null;

        //先给两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //动态数组，用来返回结果
        ArrayList<Integer> list=new ArrayList<>();

        //两个指针 p1，p2
        int p1=0,p2=0;

        //循环  终止条件  p1<nums1.length&&p2<nums2.length
        while (p1<nums1.length&&p2<nums2.length){
            if(nums1[p1]==nums2[p2]){// p1 == p2  add  p1++  p2++
                list.add(nums1[p1]);
                p1++;
                p2++;
                continue;
            }else if (nums1[p1]>nums2[p2]){//  p1>p2  p2++
                p2++;
                continue;
            }else {//  p2>p1  p1++
                p1++;
                continue;
            }
        }

        //list  -->  array
        int[] rt=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rt[i] = list.get(i);
        }
        return rt;

    }

}
