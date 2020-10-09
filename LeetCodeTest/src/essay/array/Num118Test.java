package essay.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-04 9:23
 *
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Num118Test {

}
class Num118Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arrayList=new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> array= new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                if(j==0){
                    array.add(1);
                    continue;
                }else if(j==i){
                    array.add(1);
                    continue;
                }else {
                    array.add(arrayList.get(i-1).get(j-1)+arrayList.get(i-1).get(j));
                }
            }
            arrayList.add(array);
        }
        return arrayList;
    }
}