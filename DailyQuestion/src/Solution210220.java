// 2.20
// 697. Degree of an Array(数组的度)

/*
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.

输入：[1,2,2,3,1,4,2]
输出：6
 
提示：
nums.length 在1到 50,000 区间范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。
*/

import java.util.HashMap;

public class Solution210220 {
    public int findShortestSubArray(int[] nums) {
        //构建一个哈希表，每个出现的数字映射到一个长度为3的数组：出现次数、第一次出现位置、最后一次出现位置
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
                map.replace(nums[i], temp);
            } else {
                int[] temp = new int[3];
                temp[0] = 1;
                temp[1] = i;
                temp[2] = i;
                map.put(nums[i], temp);
            }
        }
        //找出出现次数最多且首尾距离最短的数字
        int maxtime = 0;
        int len = 0;
        for (int num : map.keySet()) {
            int[] temp = map.get(num);
            if (temp[0] > maxtime) {
                maxtime = temp[0];
                len = temp[2] - temp[1] + 1;
            } else if (temp[0] == maxtime) {
                len = Math.min((temp[2] - temp[1] + 1), len);
            }
        }
        return len;
    }
}
