// 2.6
// 1423. Maximum Points You Can Obtain from Cards(可获得的最大点数)

/*
几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。

输入：cardPoints = [1,2,3,4,5,6,1], k = 3
输出：12
解释：第一次行动，不管拿哪张牌，你的点数总是 1 。
但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。

输入：cardPoints = [2,2,2], k = 2
输出：4
解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。

输入：cardPoints = [9,7,7,9,7,7,9], k = 7
输出：55
解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。

输入：cardPoints = [1,1000,1], k = 1
输出：1
解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。

输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
输出：202

提示：
1 <= cardPoints.length <= 10^5
1 <= cardPoints[i] <= 10^4
1 <= k <= cardPoints.length
*/

public class Solution210206 {
    public int maxScore(int[] cardPoints, int k) {
/*        //前缀和数组
        int presum[] = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            presum[i + 1] = presum[i] + cardPoints[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            res = Math.min(res, presum[i + cardPoints.length - k] - presum[i]);
        }
        return presum[cardPoints.length] - res;*/

        //滑动窗口，长度：cardPoints.length-k
        int left = 0, right = cardPoints.length - k;
        int sum = 0;
        for (int i = left; i < right; i++) {
            sum += cardPoints[i];
        }
        int totalsum = sum;
        int res = sum;
        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[left] + cardPoints[right];
            totalsum += cardPoints[right];
            res = Math.min(res, sum);
            left++;
            right++;
        }
        return totalsum - res;
    }
}
