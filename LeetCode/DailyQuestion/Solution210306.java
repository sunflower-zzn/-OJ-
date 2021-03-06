// 3.6
// 503. Next Greater Element II(下一个更大元素2)

/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
如果不存在，则输出 -1。

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
注意: 输入数组的长度不会超过 10000。
*/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution210306 {
    public int[] nextGreaterElements(int[] nums) {
        /*int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        //暴力遍历 n^2
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums.length; j++) {
                if (nums[i] < nums[j % nums.length]) {
                    res[i] = nums[j % nums.length];
                    break;
                }
            }
        }
        return res;*/

        //单调栈：记录元素下标，栈顶元素对应的元素下标在栈内最小
        //注：此例中stack长度最大确定，还可以用数组模拟单调栈来进一步缩短时间
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> que = new LinkedList<>();
        //遍历两倍数组长度即可(相当于把前n-1个元素拼在后面)
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!que.isEmpty() && nums[que.peek()] < nums[i % nums.length]) {
                res[que.pop()] = nums[i % nums.length];
            }
            que.push(i % nums.length);
        }
        return res;
    }
}