package essay.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-12 20:25
 */
public class Num448Test {
}
class Num448Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            index=Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)
                list.add(i+1);
        }

        return list;
    }
}