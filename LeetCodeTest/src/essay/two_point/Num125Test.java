package essay.two_point;

import org.junit.Test;

/**
 * @author cj
 * @create 2020-11-10 10:38
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome/
 * <p>
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Num125Test {
    @Test
    public void test() {

    }

    public boolean isPalindrome(String s) {

        //1，空串为回文串，返回true
        if (s.length() == 0 || s == null)
            return true;

        //String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
        s = s.toLowerCase();

        //转为数组
        char[] str = s.toCharArray();
        int low = 0, high = str.length - 1;
        char st, ed;


        //2，双指针，前后检索，终止条件 low > high
        while (low < high) {
            st = str[low];
            ed = str[high];

            //判断是否为字母或数字
            if (!((st >= 'a' && st <= 'z') || (st >= '0' && st <= '9'))) {
                low++;
                continue;
            }
            if (!((ed >= 'a' && ed <= 'z') || (ed >= '0' && ed <= '9'))) {
                high--;
                continue;
            }

            //不等结束
            if (st != ed)
                return false;

            //相等   驱动下个循环
            low++;
            high--;
        }
        return true;
    }
}
