// 11.08
// 122 Best Time to Buy and Sell Stock II

/*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    Input: [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    Input: [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
                 engaging multiple transactions at the same time. You must sell before buying again.

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
     
    Constraints:
    1 <= prices.length <= 3 * 10 ^ 4
    0 <= prices[i] <= 10 ^ 4
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201108 {
    public int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        List<Integer> top=new ArrayList<Integer>();
        List<Integer> foot=new ArrayList<Integer>();
        if(prices[0]<prices[1])foot.add(prices[0]);
        for(int i=1;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]&&prices[i-1]>=prices[i]){
                foot.add(prices[i]);
            }
            if(prices[i]>=prices[i+1]&&prices[i-1]<prices[i]){
                top.add(prices[i]);
            }
        }
        if(prices[prices.length-1]>=prices[prices.length-2])top.add(prices[prices.length-1]);
        int result=0;
        for(int i=0;i<Math.min(top.size(),foot.size());i++){result+=top.get(i)-foot.get(i);}
        return result;
    }
}
