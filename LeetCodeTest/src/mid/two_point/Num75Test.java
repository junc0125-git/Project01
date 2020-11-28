package mid.two_point;

/**
 * @author cj
 * @create 2020-11-19 10:10
 * <p>
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class Num75Test {

    //方式二：一次遍历
    public void sortColors1(int[] nums) {
        //三个指针 l，r , e
        int l, r, e, temp;
        l = 0;
        r = nums.length - 1;
        e = 0;

//        循环终止：e<=r
        while (e <= r) {
            //  ne==0 && e==l   e++ l++
            if (nums[e] == 0 && e == l) {
                e++;
                l++;
            } else if (nums[e] == 0 && nums[l] != 0) {
                //  ne==0 && nl!=0   交換  l++
                temp = nums[e];
                nums[e] = nums[l];
                nums[l] = temp;
                l++;
            } else if (nums[e] == 2 && nums[r] != 2) {
                //  ne==2 && nr!=2    交換  r--
                temp = nums[e];
                nums[e] = nums[r];
                nums[r] = temp;
                r--;
            } else if (nums[e] == 2 && e == r) {
                //  ne==2 && e==r    e++ r--
                e++;
                r--;
            } else {//  else: e++
                e++;
            }
        }

    }


    //方式一：两次遍历
    public void sortColors(int[] nums) {
        //两个指针，一前一后
        int l, r, temp;
        l = 0;
        r = nums.length - 1;

        //两次排序：
        // 1， 把全部 2 都放到最后面
        while (l < r) {
            if (nums[l] == 2 && nums[r] != 2) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
                l++;
            } else if (nums[l] != 2) {
                l++;
            } else {
                r--;
            }
        }
        //2，  把全部 0 都放到最前面
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            if (nums[l] != 0 && nums[r] == 0) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
                l++;
            } else if (nums[l] == 0) {
                l++;
            } else {
                r--;
            }
        }

    }
}
