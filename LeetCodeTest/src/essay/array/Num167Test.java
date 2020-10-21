package essay.array;

/**
 * @author cj
 * @create 2020-10-05 16:15
 */
public class Num167Test {
    /*
    好久考试开始开学上课常委会可获取我的我二月红
     */
}
class Num167Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index=new int[2];
        int low,high;
        low=0;
        high=numbers.length-1;
        while (low<high){
            if(numbers[low]+numbers[high]>target){
                high--;
            }else if (numbers[low]+numbers[high]<target){
                low++;
            }else {
                index[0]=low+1;
                index[1]=high+1;
                break;
            }
        }
        return index;


    }
}