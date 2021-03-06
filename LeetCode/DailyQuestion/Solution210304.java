// 3.4
// 354. Russian Doll Envelopes(俄罗斯套娃信封问题)

/*
给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
注意：不允许旋转信封。

输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出：3
解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

输入：envelopes = [[1,1],[1,1],[1,1]]
输出：1

提示：
1 <= envelopes.length <= 5000
envelopes[i].length == 2
1 <= wi, hi <= 104
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution210304 {
    public int maxEnvelopes(int[][] envelopes) {
        //将数组按照：第一列升序，如果第一列相同，第二列按照降序排列
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        //然后此时的数组就转化为了：对第二列的数据，求最长上升子序列（非连续）的动态规划问题！

        /*//动态规划
        int dp[] = new int[envelopes.length];
        Arrays.fill(dp, 1);      //dp[i]:到i位置的最长上升子序列长度
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                //状态转移方程：dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);      //dp[i]=max(dp[j])+1
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;*/

        //基于二分查找的动态规划
        List<Integer> f = new ArrayList<>();
        //f[j]表示当前i个数中，长度为j的递增子序列的末尾元素的最小值
        //随着i的变化，维护f
        //1、如果num>f[-1],说明num可以放到f末端，长度+1
        //2、否则，在f中找到一个小于num的数f[k],则需要更新f[k+1](使用二分查找来找到这个数)
        f.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index + 1, num);
            }
        }
        return f.size();
    }

    int binarySearch(List<Integer> f, int num) {
        //找到的是第一个不小于num的index，f单调递增是前提
        int left = 0, right = f.size() - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (f.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
