package essay.two_point;

import java.util.HashSet;

/**
 * @author cj
 * @create 2020-11-10 21:17
 * <p>
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 元音字母不包含字母 "y" 。
 */
public class Num345Test {
    public String reverseVowels1(String s) {//使用自定义函数来判断是否是元音字母，牛逼！！！！！！
        int low, high;
        low = 0;
        high = s.length() - 1;
        char[] c = s.toCharArray();
        char tag;
        while (low < high) {
            if (!isVowel(c[low])) {
                low++;
                continue;
            }
            if (!isVowel(c[high])) {
                high--;
                continue;
            }
            tag = c[low];
            c[low] = c[high];
            c[high] = tag;
            low++;
            high--;

        }
        return new String(c);
    }

    public boolean isVowel(char c) {//用来判断是否是元音字母  是：true  否：false
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;

        }
        return false;

    }

    public String reverseVowels(String s) {
        int low, high;
        low = 0;
        high = s.length() - 1;
        char[] c = s.toCharArray();
        char tag;
        char[] cr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < cr.length; i++) {
            set.add(cr[i]);
        }
        while (low < high) {
            if (!set.contains(c[low])) {
                low++;
                continue;
            }
            if (!set.contains(c[high])) {
                high--;
                continue;
            }
            tag = c[low];
            c[low] = c[high];
            c[high] = tag;
            low++;
            high--;

        }
        return new String(c);
    }
}
