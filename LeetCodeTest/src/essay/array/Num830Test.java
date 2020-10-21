package essay.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-16 14:57
 * <p>
 * #830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 */
public class Num830Test {
}

class Num830Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        char[] array = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                if (count + 1 >= 3) {
                    list.add(Arrays.asList(new Integer[]{i - count, i}));
                    count = 0;
                } else {
                    count = 0;
                }
            }
        }
        return list;

    }
}