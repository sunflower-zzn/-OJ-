// 11.18
// 134 Gas Station

/*
    在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
    如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

    说明: 
    如果题目有解，该答案即为唯一答案。
    输入数组均为非空数组，且长度相同。
    输入数组中的元素均为非负数。

    输入:
    gas  = [1,2,3,4,5]
    cost = [3,4,5,1,2]
    输出: 3
    解释:
    从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
    开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
    开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
    开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
    开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
    开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
    因此，3 可为起始索引。

    输入:
    gas  = [2,3,4]
    cost = [3,4,3]
    输出: -1
    解释:
    你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
    我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
    开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
    开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
    你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
    因此，无论怎样，你都不可能绕环路行驶一周。

*/

public class Solution201118 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        //朴素的遍历思路，从每个可能的加油站出发，看是否能走通
        int[] ans=new int[gas.length];   //维护ans数组保存每一站的净油量=加油量-耗油量
        for(int i=0;i<ans.length;i++){
            ans[i]=gas[i]-cost[i];
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]>=0){
                int temp=ans[i];
                int idx=i+1;
                while(temp>=0 && idx<i+ans.length){
                    temp+=ans[idx%ans.length];
                    idx++;
                }
                if(temp>=0 && idx==i+ans.length)return i;
            }
        }
        return -1;
        */

        //特殊想法：如果有解，总油量应该具有变化应该为从0开始到0结束，且一直大于零的折线图
        //也就是说为起点就是最低点，只需要遍历一遍找到最低点，然后以那个点为0即可
        int temp=0;
        int min=gas[0]-cost[0];
        temp+=min;
        int index=0;
        for(int i=1;i<gas.length;i++){
            temp+=gas[i]-cost[i];
            if(temp<min){
                min=temp;
                index=i;
            }
        }
        return temp<0?-1:(index+1)%gas.length;

    }

}
