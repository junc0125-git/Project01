package daily.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-22 15:23
 * <p>
 * https://leetcode-cn.com/problems/partition-labels/
 * <p>
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Num763Test {
}

class Num763Solution01 {//解法一：用哈希map存储字符的最终位置

    public List<Integer> partitionLabels(String S) {
        List<Integer> result_list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char key;
        int startIndex, endIndex, nowIndex;
        startIndex = 0;
        nowIndex = 0;
        //遍历字符串，并放到 HashMap 中，key-字符  value-字符在字符串中最后出现的位置
        for (int i = 0; i < S.length(); i++) {
            key = S.charAt(i);
            map.put(key, i);

        }
//        遍历字符串，检索字符在字符串中最后的位置，这为子串当前的长度，继续遍历，在该范围内如有其它字符
//        的终索引大，则子串长度增，直到该范围内的所有字符的所有终索引都在该范围内，将区间长度加入列表中
        endIndex = map.get(S.charAt(0));
        for (int i = 0; i < S.length(); i++) {
            if (i <= endIndex) {
                key = S.charAt(i);
                nowIndex = map.get(key);
                endIndex = endIndex > nowIndex ? endIndex : nowIndex;
            } else {
                result_list.add(endIndex - startIndex + 1);
                startIndex = i;
                key = S.charAt(i);
                nowIndex = map.get(key);
                endIndex = endIndex > nowIndex ? endIndex : nowIndex;
            }
        }
        result_list.add(endIndex - startIndex + 1);
        return result_list;
//        重复上诉过程

    }
}

/*
    数组遍历要比hashmap快很多，因为哈希需要调用很多次函数
    如何对同一字符的下标更新？？？
        用相对位置，各个字符的相对于ASCII中'a'的位置是固定的，用这个相对位置做下标，来对数组进行更新
        last[S.charAt(i) - 'a'] = i;
        同一字符减去'a'的相对位置是一个定值
 */
class Num763Solution02 {//解法二：用数组来存储字符的最终位置

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
