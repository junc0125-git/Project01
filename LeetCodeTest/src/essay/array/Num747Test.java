package essay.array;

import java.util.HashSet;

/**
 * @author cj
 * @create 2020-10-15 15:53
 */
public class Num747Test {
}
class Num747Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length==1)
            return 0;
        int max,index;
        index=0;
        max=nums[0];
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                if(nums[i]<2*max)
                    set.add(max);
                max=nums[i];
                index=i;
            }else{
                if(max<2*nums[i])
                    set.add(nums[i]);
            }
        }
        for(int num:set){
            if(max<2*num)
                return -1;
        }
        return index;
    }
}