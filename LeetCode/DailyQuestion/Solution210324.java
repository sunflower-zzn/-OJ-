import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author sunflower_zzn
 * @Date 2021/3/24 11:48
 * @Description 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 */
public class Solution210324 {
    public boolean find132pattern(int[] nums) {
        //0、暴力法（贪心，O(n^2)）

/*      //1、遍历3 O(nlogn)
        //（注意：这里的3指的是中间的那个数！找到132这种结构之后，自然它们对应的下标就能组成ijk了）
        //左边维护min_i
        //右边用TreeMap维护[j+1,nums.length-1]的所有数（红黑树）
        //遍历j：[1,nums.length-2]
        if (nums.length < 3) return false;
        int leftmin = nums[0];
        TreeMap<Integer, Integer> rightnums = new TreeMap<>();
        for (int k = 2; k < nums.length; k++) {
            rightnums.put(nums[k], rightnums.getOrDefault(nums[k], 0) + 1);
        }
        for (int j = 1; j < nums.length - 1; j++) {
            if (leftmin < nums[j]) {
                //返回不小于key的最小值，没有则返回null
                Integer right = rightnums.ceilingKey(leftmin + 1);
                if (right != null && right < nums[j]) return true;
            }
            //更新状态
            leftmin = Math.min(leftmin, nums[j]);
            rightnums.put(nums[j + 1], rightnums.get(nums[j + 1]) - 1);
            if (rightnums.get(nums[j + 1]) == 0) {
                rightnums.remove(nums[j + 1]);
            }
        }
        return false;*/

        //2、遍历1（单调栈维护2）
        //从右向左遍历1，candidate_k维护从右向左的2的候选值的单调递减栈
        //只要找到一个nums[i]<max_k即可
        if (nums.length < 3) return false;
        Deque<Integer> candidate_k = new LinkedList<>();
        candidate_k.push(nums[nums.length - 1]);
        int max_k = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < max_k) {    //说明有符合条件的i,j,k了！
                return true;
            }
            while (!candidate_k.isEmpty() && nums[i] > candidate_k.peek()) {
                //单调栈中维护了候选的2（k）的值
                max_k = candidate_k.pop();      //max_k记录了右边最大的k值
            }
            if (nums[i] > max_k) {
                //如果nums[i]的加入之后可能会增大max_k才push
                candidate_k.push(nums[i]);
            }
        }
        return false;
    }
}
