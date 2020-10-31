package essay.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-10-30 14:25
 *
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
 * 再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class Num645Test {
    @Test
    public void test1(){

    }
    //解法三：原地法，不借助任何辅助空间   根据nums[i]的值将相应位置的值取负
    public int[] findErrorNums3(int[] nums) {
        int[] result=new int[2];
        int index;
        for (int i = 0; i < nums.length; i++) {
            index=Math.abs(nums[i])-1;
            if(nums[index]<0)
                result[0]=index+1;
            else {
                nums[index]*=-1;
            }

        }
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]>0){
                result[1]=i+1;
                break;
            }
        }
        return result;
    }

    //解法二：先排序，相邻位置相的差  -->  0：重复   1：合法   2：缺失   首尾位置特殊处理
    public int[] findErrorNums2(int[] nums) {
        int[] result=new int[2];
        //排序
        Arrays.sort(nums);
        //遍历，求相邻位置的差
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                result[0]=nums[i];
            }
            if(nums[i]>nums[i-1]+1){
                result[1]=nums[i]-1;
            }
        }
        //首尾位置特殊处理
        if(nums[0]!=1)
            result[1]=1;
        if(nums[nums.length-1]!=nums.length)
            result[1]=nums.length;
        return result;
    }

    //解法一：借助o(n)的辅助空间
    public int[] findErrorNums1(int[] nums) {
        int[] result=new int[2];
        int[] temp=new int[nums.length];
        int j;
        //初始化辅助数组
        for (int i = 0; i < nums.length; i++) {
            temp[i]=0;
        }
        //辅助数组下标和目标数组值有对应关系     注：数组下标从0开始，数据从1开始，两者相差1
        for (int i = 0; i < nums.length; i++) {
            j=nums[i]-1;
            if(temp[j]!=0){//如果不是0，说明为重复的
                result[0]=j+1;
            }
            temp[j]=nums[i];
        }
        //依旧为0的说明为缺失的
        for (int i = 0; i < nums.length; i++) {
            if(temp[i]==0){
                result[1]=i+1;
                break;
            }
      }
        return result;
    }


}
