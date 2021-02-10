// 2.9
// 992. Subarrays with K Different Integers(k个不同整数的子数组)

/*
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
返回 A 中好子数组的数目。

输入：A = [1,2,1,2,3], K = 2
输出：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].

提示：
1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
*/
public class Solution210209 {
    public int subarraysWithKDistinct(int[] A, int K) {
        //找到每个位置最左边满足“最多”k个不同整数(lower)和k-1个不同整数窗口(upper)的下标
        int[] upper = new int[A.length];
        int[] lower = new int[A.length];
        find(upper, A, K - 1);
        find(lower, A, K);
        //然后将每个位置的upper[i]-lower[i]累加起来即可,k-1的减去k的就是正好等于k的
        //注意前面整数个数小于k时，upper[i]和lower[i]的值相同，相减为0
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res += upper[i] - lower[i];
        }
        return res;
    }

    void find(int[] arr, int[] nums, int k) {
        int count[] = new int[nums.length + 1];
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++) {
            if (count[nums[i]] == 0) {
                sum++;
            }
            count[nums[i]]++;
            while (sum > k) {
                count[nums[j]]--;
                if (count[nums[j]] == 0) {
                    sum--;
                }
                j++;
            }
            arr[i] = j;
        }
    }
}
