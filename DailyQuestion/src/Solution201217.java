// 12.17
// 714 Best Time to Buy and Sell Stock with Transaction Fee

/*
    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    返回获得利润的最大值。
    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

    输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
    输出: 8
    解释: 能够达到的最大利润:
    在此处买入 prices[0] = 1
    在此处卖出 prices[3] = 8
    在此处买入 prices[4] = 4
    在此处卖出 prices[5] = 9
    总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
    注意:

    0 < prices.length <= 50000.
    0 < prices[i] < 50000.
    0 <= fee < 50000.
*/

public class Solution201217 {
    public int maxProfit(int[] prices, int fee) {
        /*
        //动态规划算法
        //dp[i,0]为第i天不持有股票的收益；dp[i,1]为第i天持有股票的收益；
        //dp[i,0]=max(dp[i-1,0],dp[i-1,1]+price[i]-fee)
        //dp[i,1]=max(dp[i-1,0]-price[i],dp[i-1,1])
        //初始化：dp[0,0]=0;dp[0,1]=-price[0];
        //注意到，只有dp[i,0]和dp[i,1]需要关注，可以用两个变量来存放优化
        int buy,sell;
        sell=0;
        buy=-prices[0];
        for(int i=1;i<prices.length;i++){
            int tempsell=sell;
            int tempbuy=buy;
            sell=Math.max(tempsell,tempbuy+prices[i]-fee);
            buy= Math.max(tempsell-prices[i],tempbuy);
        }
        //最后一天持有股票肯定少于最后一天不持有股票的收益【因为多花了钱】
        return sell;
        */

        //贪心算法
        //需要寻求的就是最小买入价格和最大卖出价格
        //最大卖出价格是在收益区间内的最后一个值
        //收益区间：prices[i]>minPrice+fee
        //minPrice的变化，在收益区间内随着前一个变化而变化
        int minPrice=prices[0];
        int result=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice)minPrice=prices[i];
            if(prices[i]>minPrice+fee){     //如果没到收益区间内的最后一个值，相当于一种“虚卖出”
                result+=prices[i]-minPrice-fee;
                minPrice=prices[i]-fee;  //很重要！！保证了不会多减一次fee
            }
        }
        return result;
    }
}
