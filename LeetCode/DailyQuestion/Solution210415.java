/**
 * @Author sunflower_zzn
 * @Date 2021/4/16 11:24
 * @Description 213. 打家劫舍 II
 * * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * * <p>
 * * 输入：nums = [2,3,2]
 * * 输出：3
 * * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * * <p>
 * * 输入：nums = [1,2,3,1]
 * * 输出：4
 * * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * * 偷窃到的最高金额 = 1 + 3 = 4 。
 * * <p>
 * * 输入：nums = [0]
 * * 输出：0
 * * <p>
 * * 提示：
 * * 1 <= nums.length <= 100
 * * 0 <= nums[i] <= 1000
 */
public class Solution210415 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //两遍dp，分别求出[0,n-2]和[1,n-1]的dp，比较最大值即可
        int n1 = findMax(nums, 0, nums.length - 2);
        int n2 = findMax(nums, 1, nums.length - 1);
        return Math.max(n1, n2);
    }

    private int findMax(int nums[], int left, int right) {
        int len = right - left + 1;
        int dp[] = new int[len + 1];    //dp[i],前i间房子被偷的最大金额
        dp[0] = 0;
        dp[1] = nums[left];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1 + left]);
        }
        return dp[len];
    }

    private int plusFindMax(int nums[], int left, int right) {
        //优化dp，注意到其实只涉及dp[i-1]和dp[i-2]，维护这两个即可
        int pre = 0;
        int cur = nums[left];
        for (int i = left + 1; i <= right; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        return cur;
    }
}
