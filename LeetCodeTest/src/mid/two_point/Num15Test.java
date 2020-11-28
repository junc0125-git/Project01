package mid.two_point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cj
 * @create 2020-11-15 14:55
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Num15Test {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> rlt = new ArrayList<>();
        List<Integer> tp = new ArrayList<>();
//        int[] tp=new int[3];
        int len = nums.length;

        //先给数组排序
        Arrays.sort(nums);

        if (nums[0] > 0 || nums[len - 1] < 0)
            return rlt;

        //一层循环+双指针
        int l, r;
        int index = -1;//rlt集合下标
        for (int i = 0; nums[i] <= 0 && i < len - 2; i++) {//一层循环：遇到 >0 时停止
            //双指针：l  r   每次循环：l=i+1  r：最右边
            l = i + 1;
            r = len - 1;
            //指针移动：ns_i+ns_l+ns_r     >0 r--    <0 l++   ==0进一步判断  指针终止：l>=r
            while (l < r && nums[r] >= 0) {
                if (nums[i] + nums[l] + nums[r] > 0){
                    r--;
                    break;
                }
                else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                    break;
                }
                else {
                    if (rlt.size() != 0) {
                        tp = rlt.get(index);
                        if (!(tp.get(0) != nums[i] || tp.get(1) != nums[l] || tp.get(2) != nums[r]))
                            l++;
                        r--;
                            continue;
                    }
                    tp.add(0, nums[i]);
                    tp.add(1, nums[l]);
                    tp.add(2, nums[r]);
                    index++;
                    rlt.add(index, tp);
                    l++;
                    r--;

                }
            }
        }
        return rlt;
    }
}
