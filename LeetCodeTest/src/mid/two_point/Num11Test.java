package mid.two_point;

/**
 * @author cj
 * @create 2020-11-12 12:08
 *
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class Num11Test {

    //双指针
    public int maxArea(int[] height) {

        int nowArea,maxArea;
        nowArea=0;
        maxArea=0;

        //两根指针   分别从两边往中间移动
        int l,r;
        l=0;
        r=height.length-1;
        //每次都舍弃小的那一边    Area=min(l,r)*t  Area的大小取决于 min(l,r)和 t
        //反证法：假设保留小边，那么每移动一次， t 减小一格，由于保留的是小边，那么min(l，r)只会变得更小
        //相反，如果保留大边，每移动一次，Area的值有增大的可能，只需与当前最大值比较即可
        while(l<r){
            nowArea=Math.min(height[l],height[r])*(r-l);
            maxArea=nowArea>maxArea?nowArea:maxArea;
            if(height[l]<=height[r]){//相等时任意移动哪一边都可以
                l++;
            }else {
                r--;
            }
        }

        return maxArea;
    }

    public int maxArea_1(int[] height) {
        //暴力法  双重循环
        int nowArea,maxArea,len;
        nowArea=0;
        maxArea=0;
        len=height.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                nowArea=(j-i)*(Math.min(height[i],height[j]));
                maxArea=maxArea>nowArea?maxArea:nowArea;
            }
        }
        return maxArea;
    }


}
