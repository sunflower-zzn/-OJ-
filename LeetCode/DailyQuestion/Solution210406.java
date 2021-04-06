/**
 * @Author sunflower_zzn
 * @Date 2021/4/6 15:45
 * @Description 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class Solution210406 {
/*    public int removeDuplicates(int[] nums) {
        //暴力原地，每次删除后把之后的都补过来
        if (nums.length <= 2) return nums.length;
        int index = 1;
        int curnum = nums[0];
        int curlen = 1;
        int res = nums.length;
        while (index < res) {
            if (curnum == nums[index]) {
                if (curlen == 2) {
                    for (int i = index + 1; i < res; i++) {
                        nums[i - 1] = nums[i];
                    }
                    res--;
                } else {
                    index++;
                    curlen++;
                }
            } else {
                curnum = nums[index++];
                curlen = 1;
            }
        }
        return res;
    }*/

    //关于删除有序数组重复项的通解
    public int removeDuplicates(int[] nums) {
        //对于每一个元素，只需要跟其前k个位置的元素比较，如果相同则删去，否则加入已排序数组
        if (nums.length < 2) return nums.length;
        int cur = 2;
        int res = 2;  //长度，从第k+1个开始，初始长度为k
        while (cur < nums.length) {
            if (nums[cur] != nums[res - 2]) {
                nums[res++] = nums[cur];
            }
            cur++;
        }
        return res;
    }
}
