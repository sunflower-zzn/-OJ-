// 11.09
// 973 K Closest Points to Origin

/*
    我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
    （这里，平面上两点之间的距离是欧几里德距离。）
    你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000
*/

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution201109x {
    public int[][] kClosest(int[][] points, int K) {
        //直接排序，在抽取K个
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);

        //维护一个大小为K的大根堆，先进K个数，如果后来进来的数比根小，就把堆顶提出，将新数加入


        //快速选择思路
    }
}
