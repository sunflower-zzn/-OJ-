// 12.28
// 188. 买卖股票的最佳时机 IV

/*
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

0 <= k <= 109
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/

public class Solution201228 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<2 || k==0)return 0;
        //动态规划，将卖出股票标记为交易的终止
        //第i天j笔交易并且持有股票：buy[i][j]=max{buy[i−1][j],sell[i−1][j]−price[i]}
        //第i天j笔交易并且不持有股票：sell[i][j]=max{sell[i−1][j],buy[i−1][j−1]+price[i]}
        int[][] buy=new int[prices.length][k];
        int[][] sell = new int[prices.length][k];
        //定义两个边界条件，i==0时，任何
        for(int j=0;j<k;j++){
            buy[0][j]=Integer.MIN_VALUE;
            sell[0][j]=Integer.MIN_VALUE;
        }
        buy[0][0]=-prices[0];
        sell[0][0]=0;
        //i天最多进行i-1次交易
        for(int i=1;i<prices.length;i++){
            //由于处理buy[i][0]
            buy[i][0]=Math.max(buy[i-1][0],sell[i-1][0]-prices[i]);
            for(int j=1;j<k;j++){
                buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);
                sell[i][j]=Math.max(buy[i-1][j-1]+prices[i],sell[i-1][j]);
            }
        }
        int maxDeal=0;
        for(int i=0;i<prices.length;i++){
            //卖出一定比持有赚的多
            maxDeal=Math.max(maxDeal,sell[i][k-1]);
        }
        return maxDeal;
    }
}
