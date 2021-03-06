// 2.21
// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit(绝对差不超过限制的最长连续子数组)

/*
给你一个整数数组 nums ，和一个表示限制的整数 limit，
请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
如果不存在满足条件的子数组，则返回 0 。

输入：nums = [8,2,4,7], limit = 4
输出：2
解释：所有子数组如下：
[8] 最大绝对差 |8-8| = 0 <= 4.
[8,2] 最大绝对差 |8-2| = 6 > 4.
[8,2,4] 最大绝对差 |8-2| = 6 > 4.
[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
[2] 最大绝对差 |2-2| = 0 <= 4.
[2,4] 最大绝对差 |2-4| = 2 <= 4.
[2,4,7] 最大绝对差 |2-7| = 5 > 4.
[4] 最大绝对差 |4-4| = 0 <= 4.
[4,7] 最大绝对差 |4-7| = 3 <= 4.
[7] 最大绝对差 |7-7| = 0 <= 4.
因此，满足题意的最长子数组的长度为 2 。

输入：nums = [10,1,2,4,7,2], limit = 5
输出：4
解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。

输入：nums = [4,2,2,2,4,4,2,2], limit = 0
输出：3

提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9
*/

import java.util.Deque;
import java.util.LinkedList;

public class Solution210221 {
    public int longestSubarray(int[] nums, int limit) {
/*        //利用TreeMap数据结构，基于红黑树实现的key有序的哈希表
        //用TreeMap<数值，出现次数>模拟滑动窗口，比较最大值和最小值的差
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.replace(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;*/

        //利用两个单调队列管理最大值和最小值，进行窗口滑动
        //单调队列的特性，队列首部为某一范围内的最大值/最小值
        Deque<Integer> maxQue = new LinkedList<>();
        Deque<Integer> minQue = new LinkedList<>();
        int left = 0, right;
        int res = 0;
        for (right = 0; right < nums.length; right++) {
            //更新单调队列，维护当前窗口内的最大值和最小值
            while (!maxQue.isEmpty() && maxQue.peekLast() < nums[right]) {
                maxQue.pollLast();
            }
            while (!minQue.isEmpty() && minQue.peekLast() > nums[right]) {
                minQue.pollLast();
            }
            maxQue.offerLast(nums[right]);
            minQue.offerLast(nums[right]);
            //移除最大值/最小值，比较limit
            while (!maxQue.isEmpty() && !minQue.isEmpty() && maxQue.peekFirst() - minQue.peekFirst() > limit) {
                if (nums[left] == maxQue.peekFirst()) {
                    maxQue.pollFirst();
                }
                if (nums[left] == minQue.peekFirst()) {
                    minQue.pollFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
