package mid.two_point;

/**
 * @author cj
 * @create 2020-11-12 10:21
 * <p>
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Num03Test {

    //*************  该题目的精选题解中引申出了一系列的滑动窗口题目

    public int lengthOfLongestSubstring(String s) {

        //转为数组
        char[] array = s.toCharArray();

        //两个指针  l   r
        int l, r, nowLength, maxLength;
        l = 0;
        r = 0;
        nowLength = 0;
        maxLength = 0;

        //r 向前驱动    l 用来指示当前子串的起始位置
        while (r < array.length) {
            //每次 r 前移一格，从l开始遍历，遇到相同值，比较子串长度与最大长度，l移到子串中相同值下个位置
            r++;
            nowLength++;
            if(r==array.length){
                maxLength = maxLength > nowLength ? maxLength : nowLength;
                break;
            }

            for (int i = l; i < r; i++) {
                if (array[r] == array[i]) {
                    maxLength = maxLength > nowLength ? maxLength : nowLength;
                    nowLength =nowLength- i + l - 1;
                    l = i + 1;
                }
            }
        }
        return maxLength;
    }
}
