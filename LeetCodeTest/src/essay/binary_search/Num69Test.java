package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-22 21:21
 *
 *          https://leetcode-cn.com/problems/sqrtx/
 *
 */
public class Num69Test {

    public int mySqrt(int x) {
        //利用折半查找的思想
        // 三个指针  l , r , mid
        int l,r,mid;
        // l=0  r=x  mid=(l+r)/2
        l=0;
        r=x;
        mid=l+(r-l)/2;
        // mid*mid 与 x 比较大小   == 返回mid   >  r=mid-1    < l=mid+1
        //循环终止条件  l<=r
        while(l<=r){

            //两种方式赋给mid的值是一样的，即  l+(r-l)/2 == (l+r)/2
//            mid=(l+r)/2;//l+r: 容易发生内存溢出
            mid=l+(r-l)/2;//这样做的好处：不会发生内存溢出

            if((long)mid*mid==x){
                return mid;
            }
            else if ((long)mid*mid>x){
                r=mid-1;
            }
            else{
                l=mid+1;
            }


        }
        //  循环后在来一次判断
        //  mid*mid <= x   返回mid   else 返回 mid-1
        if(mid*mid<=x)
            return mid;
        else
            return mid-1;

    }
}
