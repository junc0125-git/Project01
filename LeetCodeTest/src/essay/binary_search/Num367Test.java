package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-23 14:34
 *
 *      https://leetcode-cn.com/problems/valid-perfect-square/
 *
 */
public class Num367Test {

    public boolean isPerfectSquare(int num) {

        //使用二分查找算法
        //1，三个指针 r, l, mid
        int l,r,mid;
        //2，初始化
        l=0;
        r=num;

        //4，循环  l<=r
        while(l<=r){
            mid=l+(r-l)/2;//好处：不会发生值溢出

            //3，mid*mid --> long型    与num比较大小  >: r=mid-1   <: l=mid+1      ==: return false
            if((long)mid*mid==num){
                return true;
            }else if ((long)mid*mid>num){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        //5，未查到满足条件的值
        return false;
    }

}
