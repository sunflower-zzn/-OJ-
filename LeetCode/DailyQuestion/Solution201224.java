// 12.24
// 135 Candy（分发糖果）

/*
    老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
    你需要按照以下要求，帮助老师给这些孩子分发糖果：
    每个孩子至少分配到 1 个糖果。
    相邻的孩子中，评分高的孩子必须获得更多的糖果。
    那么这样下来，老师至少需要准备多少颗糖果呢？

    输入: [1,0,2]
    输出: 5
    解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。

    输入: [1,2,2]
    输出: 4
    解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
         第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
*/

public class Solution201224 {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        //顺序遍历，如果比前一个评分高就获得比前一个多一个糖果，否则初始化为1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            } else {
                candys[i] = 1;
            }
        }
        //逆序遍历，如果比后一个评分高且糖果数小于等于后一个，就加一
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]) {
                candys[i] = candys[i + 1] + 1;
            }
        }
        int res = 0;
        for (int num : candys) {
            res += num;
        }
        return res;
    }

}
