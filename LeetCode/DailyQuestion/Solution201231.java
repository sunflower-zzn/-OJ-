// 12.31
// 435. Non-overlapping Intervals（无重叠区间）

/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。

输入: [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。

输入: [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
*/

import java.util.Arrays;

public class Solution201231 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) return 0;
        //首先对区间进行排序
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        //优先保留小的区间，只需要判断右边界即可，因为贪心算法！
        int right = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                //与前一个区间无重叠
                right = intervals[i][1];
            } else {   //有重叠
                right = Math.min(right, intervals[i][1]);
                res++;
            }
        }
        return res;
    }
}
