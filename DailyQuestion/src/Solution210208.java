// 2.8
// 978. Longest Turbulent Subarray(最长湍流子数组)

/*
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
返回 A 的最大湍流子数组的长度。

输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])

输入：[4,8,12,16]
输出：2

输入：[100]
输出：1

提示：
1 <= A.length <= 40000
0 <= A[i] <= 10^9
*/

public class Solution210208 {
    public int maxTurbulenceSize(int[] arr) {
        int templen = 0;
        int res = 0;
        int flag = 0;        //0-都可，1-A[k] > A[k+1],2-A[k] < A[k+1]
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag == 0) {
                if (arr[i] > arr[i + 1]) {
                    flag = 1;
                    templen++;
                } else if (arr[i] < arr[i + 1]) {
                    flag = 2;
                    templen++;
                }
            } else if (flag == 1) {
                if (arr[i] < arr[i + 1]) {
                    templen++;
                    flag = 2;
                } else {
                    res = Math.max(templen, res);
                    templen = 0;
                    flag = 0;
                    i--;
                }
            } else if (flag == 2) {
                if (arr[i] > arr[i + 1]) {
                    templen++;
                    flag = 1;
                } else {
                    res = Math.max(templen, res);
                    templen = 0;
                    flag = 0;
                    i--;
                }
            }
        }
        res = Math.max(res, templen) + 1;
        return res;
    }
}
