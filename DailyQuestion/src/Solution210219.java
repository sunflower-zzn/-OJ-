// 2.19
// 1004. Max Consecutive Ones III(最大连续1的个数)

/*
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度。

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。

提示：
1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1 
*/

public class Solution210219 {
    public int longestOnes(int[] A, int K) {
        //滑动窗口法，left和right是左右边界，num是0的个数
        int left = 0;
        int right = K - 1;
        int num = 0;
        for (int i = 0; i < K; i++) {
            if (A[i] == 0) num++;
        }
        int res = K;
        for (right = K; right < A.length; right++) {
            if (A[right] == 0) num++;
            while (num > K) {
                if (A[left] == 0) num--;
                left++;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
