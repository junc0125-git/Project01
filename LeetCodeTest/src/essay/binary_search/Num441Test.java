package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-23 15:55
 * <p>
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class Num441Test {

    public int arrangeCoins(int n) {

        //3个指针    l, r, mid
        int l, r, mid;
        //初始化
        l = 1;
        r = n;
        mid = l + (r - l) / 2;
        //循环：l<=r
        while (l <= r) {
            mid = l + (r - l) / 2;
            //比较 （1+mid)*mid/2   >n: r=mid-1        <=n: l=mid+1
            if ((long) ((1 + mid) * mid / 2) > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //循环外判断： <=n return mid    else : rt mid-1
        if ((long) ((1 + mid) * mid / 2) > n) {
            return mid-1;
        } else {
            return mid;
        }

    }


}
