package essay.two_point;

/**
 * @author cj
 * @create 2020-11-11 17:46
 * <p>
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
public class Num844Test {

    public boolean backspaceCompare(String S, String T) {

        //转为数组
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        //定义两个指针 p1  p2
        int p1 = 0, p2 = 0;

        //把 # 号或者受 # 影响的字母置为 0
        while (p1 < s.length) {
            if (s[p1] == '#') {
                s[p1] = '0';
                p2 = p1 - 1;
                while (p2 >= 0) {
                    if (s[p2] != '0') {//回退功能
                        s[p2] = '0';
                        break;
                    }
                    p2--;
                }
                p1++;
            } else {
                p1++;
            }
        }
        p1 = 0;
        p2 = 0;
        while (p1 < t.length) {
            if (t[p1] == '#') {
                t[p1] = '0';
                p2 = p1 - 1;
                while (p2 >= 0) {
                    if (t[p2] != '0') {//回退功能
                        t[p2] = '0';
                        break;
                    }
                    p2--;
                }
                p1++;
            } else {
                p1++;
            }
        }

        //依次比较非0数是否相同
        p1 = 0;
        p2 = 0;
        while (p1 < s.length && p2 < t.length) {
            if (s[p1] == '0') {
                p1++;
                continue;
            }
            if (t[p2] == '0') {
                p2++;
                continue;
            }
            if(s[p1]!=t[p2])
                return false;
            p1++;
            p2++;
        }

        //判断两者未比对结束的继续比对
        if(p1==s.length){
            while (p2<t.length){
                if(t[p2]!='0')
                    return false;
                p2++;
            }
        }else {
            while (p1<s.length){
                if(s[p1]!='0')
                    return false;
                p1++;
            }
        }

        return true;

    }
}
