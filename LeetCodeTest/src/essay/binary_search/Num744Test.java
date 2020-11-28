package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-28 10:28
 * <p>
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class Num744Test {


    public char nextGreatestLetter(char[] letters, char target) {
        //二分查找
        int len = letters.length;
        //三个指针
        int l, r, mid;
        l = 0;
        r = len - 1;
        //查找结果有四种情况
        while (l <= r) {
            mid = l + (r - l) / 2;
            //一：刚好存在target，返回下一位（判断一下是否是最后一位）
            if (target == letters[mid]) {
                while (mid < len) {
                    //可能连续出现几个target
                    if (letters[mid] == target)
                        mid++;
                    else
                        break;
                }
                //判断是否超出数组长度
                return mid < len ? letters[mid] : letters[0];
            } else if (letters[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //二：target不在数组中，但其值介于数组的某两个值之间
        //四：target 比数组中所有值都小
        if (l < len) {
            return letters[l];
        } else {
            //三：target 比数组中的所有值都大
            return letters[0];
        }
    }


}
