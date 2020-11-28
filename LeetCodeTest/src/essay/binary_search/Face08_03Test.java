package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-26 13:33
 *
 *  https://leetcode-cn.com/problems/magic-index-lcci/
 *
 *  虽然有序，但也不能用二分查找
 *
 *  引入了二分剪枝法，可用来拓展思路，已收藏
 *
 */
public class Face08_03Test {

//    暴力法
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i)
                return i;
        }
        return -1;

    }

}
