package essay.array;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author cj
 * @create 2020-10-12 16:51
 */
public class Num414Test {
}

class Num414Solution01 {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3)
                set.remove(Collections.min(set));
        }
        return set.size() < 3 ? Collections.max(set) : Collections.min(set);
    }
}

class Num414Solution02 {
    public int thirdMax(int[] nums) {
        if(nums==null||nums.length==0)
            throw new RuntimeException("nums is null or length of 0");
        long one=nums[0];
        long two=Long.MIN_VALUE;
        long three=Long.MIN_VALUE;
        for(int num:nums){
            if(num==one||num==two||num==three)
                continue;
            if(num>one){
                three=two;
                two=one;
                one=num;
            }else if(num>two){
                three=two;
                two=num;
            }else{
                three=num;
            }
        }
        if(three==Long.MIN_VALUE)
            return (int)one;
        return (int)three;
    }
}