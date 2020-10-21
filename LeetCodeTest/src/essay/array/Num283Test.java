package essay.array;

/**
 * @author cj
 * @create 2020-10-11 11:39
 */
public class Num283Test {
}

class Num283Solution01 {
    public void moveZeroes(int[] nums) {
        int isZero, zero;
        isZero = 0;
        zero = 0;
        while (isZero < nums.length && zero < nums.length) {
            if (nums[zero] != 0) {
                zero++;
                continue;
            }
            if (nums[isZero] == 0) {
                isZero++;
                continue;
            }
            if (isZero > zero) {
                nums[zero] = nums[isZero];
                nums[isZero] = 0;
            } else {
                isZero++;
            }
        }
    }
}
class Num283Solution02 {
    public void moveZeroes(int[] nums) {
        int j=0,temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j++]=temp;

            }
        }
    }
}