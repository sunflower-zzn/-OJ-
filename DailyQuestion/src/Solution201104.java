// 11.04
// 57 Insert Interval

/*
    给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    Input: intervals = [], newInterval = [5,7]
    Output: [[5,7]]

    Input: intervals = [[1,5]], newInterval = [2,3]
    Output: [[1,5]]

    Input: intervals = [[1,5]], newInterval = [2,7]
    Output: [[1,7]]

    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= intervals[i][0] <= intervals[i][1] <= 105
    intervals is sorted by intervals[i][0] in ascending order.
    newInterval.length == 2
    0 <= newInterval[0] <= newInterval[1] <= 105

*/

import java.util.ArrayList;
import java.util.List;

public class Solution201104 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        int leftnum = newInterval[0];
        int rightnum = newInterval[1];
        if (intervals.length == 0) {  //如果原数组为null，直接插入newInterval即可
            left.add(leftnum);
            right.add(rightnum);
        } else {
            int index = 0;
            //找到所有在newInterval左边的区间，直接插入list
            while (index < intervals.length && intervals[index][1] < leftnum) {
                left.add(intervals[index][0]);
                right.add(intervals[index][1]);
                index++;
            }
            //遇到newInterval，分情况处理
            if (index == intervals.length || intervals[index][0] > rightnum) {  //newInterval在最右边，或，如果newInterval与其右边的区间没有重叠，直接插入
                left.add(leftnum);
                right.add(rightnum);
            } else {  //有重叠部分
                leftnum = Math.min(intervals[index][0], leftnum);
                while (index < intervals.length && intervals[index][0] <= rightnum) {  //找到没有重叠的后面第一个区间
                    index++;
                }
                rightnum = Math.max(intervals[index - 1][1], rightnum);
                left.add(leftnum);
                right.add(rightnum);
            }
            //将剩余的右边区间插入
            while (index < intervals.length && intervals[index][0] > rightnum) {
                left.add(intervals[index][0]);
                right.add(intervals[index][1]);
                index++;
            }
        }
        int[][] res = new int[left.size()][2];
        for (int i = 0; i < left.size(); i++) {
            res[i][0] = left.get(i);
            res[i][1] = right.get(i);
        }
        return res;
    }
}
