package essay.array;

/**
 * @author cj
 * @create 2020-09-25 9:05
 *
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Num66Test {
}
class Num66Solution {
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i] += 1;
                break;
            }
        }
        if(digits[0]==0){
            int length =digits.length+1 ;
            digits = new int[length];
            digits[0] = 1;
            //此处系统会默认给其他数组赋值为 0  （默认初始化赋值）
        }
        return digits;

    }
}