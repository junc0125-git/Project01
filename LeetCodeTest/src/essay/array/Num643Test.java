package essay.array;

/**
 * @author cj
 * @create 2020-10-13 14:55
 */
public class Num643Test {
    public static void main(String[] args) {
        System.out.println(Math.max(-Double.MAX_VALUE,-1));
    }
}

class Num643Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage, average;
        int sum;
        maxAverage = -Double.MAX_VALUE;
        sum = 0;
        for(int i=0;i<nums.length;i++){
            if(i<k){
                sum+=nums[i];
                if(i==k-1){
                    average=(double)sum/k;
                    maxAverage= Math.max(maxAverage, average);
                }
            }else{
                sum+=nums[i]-nums[i-k];
                average=(double)sum/k;
                maxAverage= Math.max(maxAverage, average);
            }
        }
        return maxAverage;
    }
}