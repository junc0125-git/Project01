package essay.array;

/**
 * @author cj
 * @create 2020-10-13 14:20
 */
public class Num605Test {
}
class Num605Solution01 {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int count;
        count=0;
        if(nums[0]==0&&nums.length==1){
            nums[0]=1;
            count++;
            if(count>=n)
                return true;
            else
                return false;
        }else if(nums[0]==1&&nums.length==1){
            if(count>=n)
                return true;
            else
                return false;
        }


        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]==0&&nums[i+1]==0){
                    nums[0]=1;
                    count++;
                    continue;
                }else{
                    continue;
                }

            }
            if(i==nums.length-1){
                if(nums[i]==0&&nums[i-1]==0){
                    nums[nums.length-1]=1;
                    count++;
                    break;
                }else{
                    break;
                }
            }
            if(nums[i-1]==0&&nums[i]==0&&nums[i+1]==0){
                nums[i]=1;
                count++;
                continue;
            }
        }
        if(count>=n)
            return true;
        else
            return false;
    }
}
class Num605Solution02 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}
