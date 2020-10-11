package essay.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cj
 * @create 2020-10-11 10:10
 */
public class Num219Test {
}

class Num219Solution01 {//哈希表

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = map.get(nums[i]) - i;
                if (result >= -k && result <= k)
                    return true;
                else
                    map.replace(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

class Num219Solution02 {//滑动窗口

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<Integer>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[j]);
                j++;
            }

        }
        return false;
    }
}