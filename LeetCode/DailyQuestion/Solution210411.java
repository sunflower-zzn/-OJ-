/**
 * @Author sunflower_zzn
 * @Date 2021/4/11 12:58
 * @Description 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * 1 <= n <= 1690
 */
public class Solution210411 {
/*    public int nthUglyNumber(int n) {
        //优先级队列(最小堆)。每次取出最小值，然后放入2x,3x,5x
        //用hashset维护最小堆中数据唯一性
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] times = {2, 3, 5};
        minHeap.add((long) 1);
        set.add((long) 1);
        long res = 0;
        while (n > 0) {
            res = minHeap.poll();
            for (int i = 0; i < 3; i++) {
                long temp = res * times[i];
                if (!set.contains(temp)) {
                    set.add(temp);
                    minHeap.add(temp);
                }
            }
            n--;
        }
        return (int) res;
    }*/

    public int nthUglyNumber(int n) {
        //dp动态规划，维护三个p，分别代表质因数中2，3，5的个数
        int dp[] = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
        }
        return dp[n - 1];
    }
}
