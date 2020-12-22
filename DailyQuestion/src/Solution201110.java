// 11.10
// 31 Next Permutation

/*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。
    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
*/

public class Solution201110 {
    public void nextPermutation(int[] nums) {
        //思路：找到字典序的下一个，如果是完全降序，则返回完全升序
        //如何找到字典序的下一个：有右往左查找找到第一个升序结构的nums[i-1]<nums[i]
        //然后查找nums[i-1]右边降序结构中，比nums[i-1]大的最小值nums[k]，交换
        //然后将nums[i-1]后的数字升序排列即可！
        if (nums.length < 2) return;
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {  //全为降序，将整个数组逆序即可
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        } else {
            //找到index之后比nums[index]大的最小值nums[k]，并交换
            int k = index + 1;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] > nums[index] && nums[i] <= nums[k]) {
                    k = i;
                }
            }
            int temp = nums[k];
            nums[k] = nums[index];
            nums[index] = temp;
            //将index后的数据逆序为升序
            for (int i = index + 1; i < (nums.length - (index + 1)) / 2 + (index + 1); i++) {
                temp = nums[i];
                nums[i] = nums[(nums.length - 1) - (i - index - 1)];
                nums[(nums.length - 1) - (i - index - 1)] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution201110 s = new Solution201110();
        int[] nums = {1, 3, 2};
        s.nextPermutation(nums);
    }

}
