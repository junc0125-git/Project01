package daily.question;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author cj
 * @create 2020-11-04 10:20
 *
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Num57Test {
    @Test
    public void test(){
        ArrayList<int[]> rt=new ArrayList<>();
        rt.toArray(new int[rt.size()][]);
        
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        // 判断左边不重合
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 判断重合
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        // 判断右边不重合
        while (i < len && intervals[i][0] > newInterval[1]) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }

    /*public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        LinkedList<int[]> ret = new LinkedList<>();
        int[] temp = null;
        Boolean flag = null; // 是否已相交
        for (int i = 0, length = intervals.length; i < length; i ++) {
            int[] interval = intervals[i];
            int x = interval[0], y = interval[1];
            if (x == newInterval[0] && y == newInterval[1]) // 为子集
                return intervals;
            if (flag != null) {
                if (flag) {
                    left = temp[0];
                    right = temp[1];
                } else {
                    ret.add(interval);
                    continue;
                }
            }

            if (x < left && y >= left && y <= right) { // 左相交
                temp = new int[] {x, right};
                flag = true;
            } else if (x >= left && x <= right && y > right) { // 右相交
                temp = new int[] {left, y};
                flag = true;
            } else if ((x >= left && y <= right) || (x <= left && y >= right)) { // 包含
                temp = new int[] {Math.min(x, left), Math.max(y, right)};
                flag = true;
            } else if (x > right) {
                flag = false;
                ret.add(temp == null ? newInterval : temp);
                ret.add(interval);
            } else if (flag == null) {
                ret.add(interval);
            }
        }
        if (flag == null) { // 新增为最大
            ret.add(newInterval);
        } else if (flag) {
            ret.add(temp);
        }
        return ret.toArray(new int[ret.size()][2]);
    }*/

    /*public int[][] insert(int[][] intervals, int[] newInterval) {
        int len=intervals.length;

        if(newInterval[1]>=intervals[0][0]&&newInterval[1]<=intervals[0][1]){
            intervals[0][0]=newInterval[0];
            return intervals;
        }

        if(newInterval[0]<=intervals[len-1][1]&&newInterval[0]>=intervals[len-1][0]){
            intervals[len-1][1]=newInterval[1];
            return intervals;
        }

        int[][] rt=new int[len+1][2];

        if(newInterval[1]<intervals[0][0]){
            rt[0][0]=newInterval[0];
            rt[0][1]=newInterval[1];
            for (int i = 0; i < len; i++) {
                rt[i+1][0]=intervals[i][0];
                rt[i+1][1]=intervals[i][1];
            }
            return rt;
        }

        if(newInterval[0]>intervals[len-1][1]){
            for (int i = 0; i < len; i++) {
                rt[i][0]=intervals[i][0];
                rt[i][1]=intervals[i][1];
            }
            rt[len-1][0]=newInterval[0];
            rt[len-1][1]=newInterval[1];
            return rt;
        }



        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0]>intervals[i][1]){
                rt[i][0]=intervals[i][0];
                rt[i][1]=intervals[i][1];
            }else if(newInterval[0]<intervals[i][1]){
                if(newInterval[1]<intervals[i][0]){
                    rt[i][0]=newInterval[0];
                    rt[i][1]=newInterval[1];
                    copys(rt,intervals,i+1,i);
                    return rt;
                }
            }
            
        }
        return rt;
    }
    public void copys(int[][] a,int[][] b,int ast,int bst){//将 b --> a
        for (int i = bst; i < b.length; i++) {
            a[ast][0]=b[i][0];
            a[ast][1]=b[i][1];
            ast++;
        }

    }*/
}
