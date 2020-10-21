package essay.array;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author cj
 * @create 2020-10-14 22:13
 */
public class Num697Test {
}

class Num697Solution01 {
    public int findShortestSubArray(int[] nums) {
        //1，定义三个哈希表，right,left,count
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();

        //2对于left和right，以num值为key，下标为value，用来记录某个数的最左最右下标
        //3对于count，以num为key，num在数组中出现的次数作为value
        for (int i = 0; i < nums.length; i++) {
            //4，若某个num对应的left为空，便将num值和下标加入left，否则加入right，并且将num对应的count的value值加1
            if (!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i],i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
      //5，通过最大maxCount在count中找对应的num值，在通过num值查找对应的left和right，找到最小的right-left+1并返回
        int maxCount= Collections.max(count.values());
        int ans=nums.length;
        for(int key:count.keySet()){
            if(count.get(key)==maxCount)
                ans=Math.min(ans,right.get(key)-left.get(key)+1);
        }
        return ans;

    }
}