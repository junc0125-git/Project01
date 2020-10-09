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