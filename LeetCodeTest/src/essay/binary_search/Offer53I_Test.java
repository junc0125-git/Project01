package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-26 10:49
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53I_Test {

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        //先通过二分查找定位到数字
        //三指针  l,r,mid
        int l, r, mid;
        l = 0;
        r = nums.length - 1;
        //计数器
        int count = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;

            // nums_mid   >target: r=mid-1   <target: l=mid+1   ==target: 开启计数
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                //开启计数
                count++;
                //在分别左右统计
                //向左计数
                for (int i = mid - 1; i >= 0; i--) {
                    if (nums[i] == target)
                        count++;
                    else
                        break;
                }
                //向右计数
                for (int i = mid + 1; i < nums.length; i++) {
                    if (nums[i] == target)
                        count++;
                    else
                        break;
                }
                //计数完毕
                break;
            }
        }
        return count;
    }

}
