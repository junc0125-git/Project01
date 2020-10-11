package com.nowcoder;

/**
 * @author cj
 * @create 2020-09-21 18:45
 *
 * # 4. 二维数组中的查找
 *
 * ## 题目链接
 *
 * [牛客网](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github)
 *
 * ## 题目描述
 *
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * ```html
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 * ```
 *
 * ## 解题思路
 *
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 *
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 *
 * <div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/35a8c711-0dc0-4613-95f3-be96c6c6e104.gif" width="400px"> </div><br>
 *
 * ```java
 * public boolean Find(int target, int[][] matrix) {
 *     if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
 *         return false;
 *     int rows = matrix.length, cols = matrix[0].length;
 *     int r = 0, c = cols - 1; // 从右上角开始
 *     while (r <= rows - 1 && c >= 0) {
 *         if (target == matrix[r][c])
 *             return true;
 *         else if (target > matrix[r][c])
 *             r++;
 *         else
 *             c--;
 *     }
 *     return false;
 * }
 * ```
 *
 *
 *
 *
 *
 *
 * <div align="center"><img width="320px" src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/githubio/公众号二维码-2.png"></img></div>
 *
 */
public class JZ01Test {

    public static void main(String[] args){
        int target;
        int[][] array = {{7,12,23},{13,25,36}};
//        array =
        target=10;
        Solution sl = new Solution();
        boolean rs = sl.Find(target,array);
        System.out.println(rs);

    }

}
class Solution {
    public boolean Find(int target, int [][] array) {
        //判断数组是否为空
        if(array==null||array.length==0||array[0].length==0)
            return false;
        int i=0,j=array[0].length-1;
        while(i<array.length&&j>=0){
            if(array[i][j]==target)
                return true;
            else if(array[i][j]<target)
                i++;
            else
                j--;
        }
        return false;

    }
}