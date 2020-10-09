package essay.array;

/**
 * @author cj
 * @create 2020-09-23 19:34
 * <p>
 * # 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class Num27Test {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("");
    }
}

class Num27Solution {
    //解法3：双指针尾部减少法：这是对解法二的提升，即，每次都把尾部的值覆盖到当前需要删除元素的位置，
    // 然后让数组长度-1。
    // 注意：可能覆盖后的值依旧需要删除，所以覆盖后的位置需要重新检索


    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length, i = 0;
        while (i < length) {
            if (nums[i] == val) {

                nums[i] = nums[length - 1];
                length--;
            } else {
                i++;
            }

        }
        return length;
    }

}
/*
class Num27Solution {//解法1 双层循环法：找到要删的值时，启动内层循环找到合适的值交换，如果未找到，直接返回长度退出
    public int removeElement(int[] nums, int val) {
        int temp,j,i;
        for(i=0;i<nums.length;i++){
            if(val==nums[i]){
                for(j= i+1;j<nums.length;j++){
                    if(val!=nums[j]){
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                if(j>=nums.length)
                    return i;
            }
        }
        return i;
    }
}*/

/*
class Num27Solution {
    //解法2：双指针覆盖法，一快一慢两个指针，用快指针把所有！=val的值都覆盖到前面来，慢指针用来记录覆盖次数，即数组长度
    //缺点：{1,2,3,4} val=4  前面三个元素进行了自身覆盖，这是白费工
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}*/
