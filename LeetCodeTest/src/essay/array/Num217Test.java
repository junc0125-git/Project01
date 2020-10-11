package essay.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author cj
 * @create 2020-10-11 10:00
 */
public class Num217Test {
}

class Num217Solution01 {//解法一

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;

        }
        return false;

    }
}

class Num217Solution02 {//解法二：HashSet

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}