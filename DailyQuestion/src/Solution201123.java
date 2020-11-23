// 11.23
// 452 Minimum Number of Arrows to Burst Balloons

/*
    在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
    由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
    一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
    且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
    我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
    给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。

    Input: points = [[10,16],[2,8],[1,6],[7,12]]
    Output: 2
    Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

    Input: points = [[1,2],[3,4],[5,6],[7,8]]
    Output: 4

    Input: points = [[1,2],[2,3],[3,4],[4,5]]
    Output: 2

    Input: points = [[1,2]]
    Output: 1

    Input: points = [[2,3],[2,3]]
    Output: 1

    Constraints:
    0 <= points.length <= 104
    points[i].length == 2
    -231 <= xstart < xend <= 231 - 1
*/

import java.util.Arrays;

public class Solution201123 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        //先将二维数组排序，然后寻找每一个[start,end]的重合次数
        Arrays.sort(points, (o1, o2) -> {
            //一定要用Integer.compare(o1[1],o2[1])来比较！否则过不了这个用例：
            //[[-2147483646,-2147483645],[2147483646,2147483647]]
            return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
        });
        int res = 1;
        int[] arrowPos = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrowPos[1]) {
                arrowPos[0] = points[i][0];
                arrowPos[1] = Math.min(arrowPos[1], points[i][1]);
            } else {
                res++;
                arrowPos = points[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        Solution201123 s = new Solution201123();
        s.findMinArrowShots(points);
    }
}
