package essay.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-04 10:17
 * <p>
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Num119Test {
}

class Num119Solution01 {//暴力法：先求出整个杨辉三角，然后在取出某一行

    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        return list.get(rowIndex);
    }
}

/*
class Num119Solution02 {//暴力法：先求出整个杨辉三角，然后在取出某一行

    public List<Integer> getRow(int rowIndex) {
        int rowNums = rowIndex + 1;
        int temp;
        int[] array=new int[rowNums];
        for(int i=0;i<rowNums;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    array[j]=1;
                }else{

                }
            }
        }
    }
}*/
