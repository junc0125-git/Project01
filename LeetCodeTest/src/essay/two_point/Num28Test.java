package essay.two_point;

import org.junit.Test;

/**
 * @author cj
 * @create 2020-11-10 9:02
 * <p>
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Num28Test {

    @Test
    public void test() {

    }

    public int strStr1(String haystack, String needle) {//双指针

        //1，needle为空，返回 0    空串也是字符串
        if (needle == null || needle.length() == 0)
            return 0;

        //2，needle长度大于haystack，返回-1
        if (needle.length() > haystack.length())
            return -1;

        //3，转换成数组，使用双指针遍历
        char[] hStr = haystack.toCharArray();
        char[] nStr = needle.toCharArray();

        int j = 0;
        //第一重循环，剩余长度<need长度时停止   i<h.l-n.l+1
        for (int i = 0; i < hStr.length - nStr.length + 1; i++) {
            for (j = 0; j < nStr.length; j++) {
                if (hStr[i + j] != nStr[j])
                    break;
            }
            if (!(j < nStr.length))
                return i;

        }
        return -1;
    }

    public int strStr(String haystack, String needle) {//方法1：遍历比较子串   时间复杂度O(n*m)
        String target = "";
        //1，needle为空，返回 0    空串也是字符串
        if (needle == null || needle.length() == 0)
            return 0;
        //2，needle长度大于haystack，返回-1
        if (needle.length() > haystack.length())
            return -1;

        char st = needle.charAt(0);
        //3，haystack 长度大于等于 needle，继续判断是否满足条件
        //第一重循环，剩余长度<need长度时停止   i<h.l-n.l+1
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == st) {
                //截取子串，调用函数比较
                target = haystack.substring(i, i + needle.length());//左闭右开
                if (needle.equals(target))
                    return i;
            }
        }
        //匹配失败，返回-1
        return -1;
    }
}
