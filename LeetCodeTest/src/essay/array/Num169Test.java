package essay.array;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-10-05 16:49
 */
public class Num169Test {
    public static void main(String[] args) {
        Num169Solution test = new Num169Solution();
        int[] nums={3,2,3};
        int result=test.majorityElement(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}
class Num169Solution {
    public int majorityElement(int[] nums) {
        int target,number;
        number=0;
        target=nums.length/2;
        Arrays.sort(nums);
        if(nums.length==1)
            return nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                number++;
                if(i+1==nums.length-1){
                    if(number+1>target)
                        return nums[i];
                    else
                        break;
                }
            }else {
                if(number+1>target)
                    return nums[i];
                else
                    number=0;
            }
        }
        return -1;

    }
}
class Num169Solution01 {
    /*

    方法四：分治
思路

如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。

我们可以使用反证法来证明这个结论。假设 a 既不是左半部分的众数，也不是右半部分的众数，
那么 a 出现的次数少于 l / 2 + r / 2 次，其中 l 和 r 分别是左半部分和右半部分的长度。
由于 l / 2 + r / 2 <= (l + r) / 2，说明 a 也不是数组 nums 的众数，因此出现了矛盾。所以这个结论是正确的。

这样以来，我们就可以使用分治法解决这个问题：将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，
随后在 a1 和 a2 中选出正确的众数。

算法

我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。长度为 1 的子数组中唯一的数显然是众数，
直接返回即可。如果回溯后某区间的长度大于 1，我们必须将左右子区间的值合并。如果它们的众数相同，
那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
}

