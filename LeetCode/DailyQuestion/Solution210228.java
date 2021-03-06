// 2.28
// 896. Monotonic Array(单调数列)

/*
如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。

输入：[1,2,2,3]
输出：true

输入：[6,5,4,4]
输出：true

输入：[1,3,2]
输出：false

输入：[1,2,4,5]
输出：true

输入：[1,1,1]
输出：true
 
提示：
1 <= A.length <= 50000
-100000 <= A[i] <= 100000
*/

public class Solution210228 {
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) return true;
        int monoionic = 0; //单调性：1-单调递增，2-单调递减
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (monoionic == 0) monoionic = 1;
                else if (monoionic == 2) return false;
            } else if (A[i] < A[i - 1]) {
                if (monoionic == 0) monoionic = 2;
                else if (monoionic == 1) return false;
            }
        }
        return true;
    }
}
