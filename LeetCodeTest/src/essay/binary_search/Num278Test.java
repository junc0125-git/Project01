package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-23 12:56
 *
 *  https://leetcode-cn.com/problems/first-bad-version/
 *
 */
public class Num278Test {

    //测试版本号是否错误，错误 返回 True
    boolean isBadVersion(int version){
        return false;
    }

    public int firstBadVersion(int n) {
        //找第一个出错的版本号，一个出错后，其后全出错
        //第一个出错版本号满足的条件：其自身往后全出错，即 isBadVersion()返回true      其前一个返回false
        //折半查找  三个指针  l , r , mid
        int l,r,mid;
        l=0;
        r=n;
        mid=l+(r-l)/2;
        //循环终止条件 l>r
        while(l<=r){

            //两种方式赋给mid的值是一样的，即  l+(r-l)/2 == (l+r)/2
//            mid=(l+r)/2;//l+r: 容易发生内存溢出
            mid=l+(r-l)/2;//这样做的好处：不会发生内存溢出

            //分支判断 isMid T r=mid-1  F l=mid+1
            if(isBadVersion(mid)){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        //循环外判断一步
        //idMid T rt mid  F: rt mid+1
        if(isBadVersion(mid))
            return mid;
        else
            return mid+1;

    }
}
