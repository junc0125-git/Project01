package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-26 13:32
 *
 *  https://leetcode-cn.com/problems/sparse-array-search-lcci/
 *
 *  在某些位置，二分法需要退化为线性
 *  二分法+线性
 *
 */
public class Face10_05Test {

//    暴力法
    public int findString(String[] words, String s) {
        for(int i=0;i<words.length;i++){
            if(s.equals(words[i]))
                return i;
        }
        return -1;
    }
}
