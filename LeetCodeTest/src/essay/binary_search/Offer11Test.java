package essay.binary_search;

/**
 * @author cj
 * @create 2020-11-24 9:09
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class Offer11Test {
    public int minArray(int[] numbers) {
        //旋转元素个数为0
        if(numbers[numbers.length-1]>numbers[0])
            return numbers[0];
        //使用折半查找的方法
        //使用三个指针 l  r   mid
        int l,r,mid;
        l=0;
        r=numbers.length-1;
        mid=l+(r-l)/2;
        //一个标识值 tag = n[0]    因为移到后面的值都比 n_0 小，原来的值都比 n_0大，
        int tag=numbers[0];
        //循环条件：l<=r
        while (l<=r){
            mid=l+(r-l)/2;
            //n_mid :  >=tag   l=mid+1    <tag: r=mid-1
            if(numbers[mid]>tag){
                l=mid+1;
            }else if(numbers[mid]<tag){
                r=mid-1;
            }else{

            }
        }
        //循环外判断     n_mid :  >=tag: rt n_mid+1    <tag: rt n_mid
        if(numbers[mid]>=tag){
            return numbers[mid+1];
        }else{
            return numbers[mid];
        }
    }
}
