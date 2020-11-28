package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-23 16:50
 *
 *      https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 */
public class Offer53II_Test {

    public int missingNumber(int[] nums) {
        //采用二分查找
        //三个指针  l   r   mid    下标
        int l,r,mid;
        //初始化
        l=0;
        r=nums.length-1;
        mid=l+(r-l)/2;
        //循环条件：l<=r
        while (l<=r){
            mid=l+(r-l)/2;

            //由于是按顺序排列，且有缺失，所以  ns_mid >= mid 恒成立（原因：数值和下标本该相等，但数值有缺失，但下标还是连号的）
            //ns_mid == mid   l=mid+1   ns_mid  > mid  r=mid-1
            if(nums[mid]==mid){
                l=mid+1;
            }else {//ns_mid > mid  因为所有数字都是唯一的，所以不存在 ns_mid < mid 的情况
                r=mid-1;
            }
        }
        //循环外判断一下 ：ns_mid == mid rt mid+1       ns_mid  > mid  rt  mid
        if(nums[mid]==mid){
            return mid+1;
        }else {//ns_mid > mid  因为所有数字都是唯一的，所以不存在 ns_mid < mid 的情况
            return mid;
        }
    }

}
