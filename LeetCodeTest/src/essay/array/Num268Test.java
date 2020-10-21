package essay.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author cj
 * @create 2020-10-11 11:13
 */
public class Num268Test {
}

class Num268Solution01 {
    public int missingNumber(int[] nums) {
        int i;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return i;

    }
}

class Num268Solution02 {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i;
        for (int num : nums)
            set.add(num);
        for (i = 0; i < nums.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return i;
    }
}