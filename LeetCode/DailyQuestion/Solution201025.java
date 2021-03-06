// 10.25
// 845 Longest Mountain in Array

/*
    我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
        B.length >= 3
        存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
    给出一个整数数组 A，返回最长 “山脉” 的长度。
    如果不含有 “山脉” 则返回 0。

    Input: [2,1,4,7,3,2,5]
    Output: 5
    Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

    Input: [2,2,2]
    Output: 0
    Explanation: There is no mountain.

    0 <= A.length <= 10000
    0 <= A[i] <= 10000
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201025 {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0; // 山脉的最小长度为3，不满足直接返回0
        int res = 0;
        int frontfoot = -1;  // frontfoot表示山脚，如果=-1则为左边，>-1则为右边
        if (A[0] < A[1]) frontfoot = 0;  //处理第一个A[0]
        for (int i = 1; i < A.length - 1; i++) {
            if (frontfoot == -1) {
                //左山脚情况
                if (A[i] <= A[i - 1] && A[i] < A[i + 1]) {
                    frontfoot = i;
                }
            } else {
                //山中出现相等，不构成山，清空左山脚
                if (A[i] == A[i - 1]) {
                    frontfoot = -1;
                }
                //下降并跟后一个相等，只能是右山脚，清空山脚
                else if (A[i] < A[i - 1] && A[i] == A[i + 1]) {
                    res = Math.max((i - frontfoot + 1), res);
                    frontfoot = -1;
                }
                //v字型，既是右山脚又是下一个左山脚
                else if (A[i] < A[i - 1] && A[i] < A[i + 1]) {
                    res = Math.max((i - frontfoot + 1), res);
                    frontfoot = i;
                }
            }

        }
        if (A[A.length - 1] < A[A.length - 2]) {
            if (frontfoot > -1) {
                res = Math.max((A.length - 1 - frontfoot + 1), res);
                frontfoot = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int A[] = {875, 884, 239, 731, 723, 685};
        Solution201025 s = new Solution201025();
        int result = s.longestMountain(A);
        System.out.println(result);
    }


}
