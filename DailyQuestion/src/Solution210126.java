// 1.26
// 1128. Number of Equivalent Domino Pairs(多米诺骨牌数量)

/*
给你一个由一些多米诺骨牌组成的列表 dominoes。
如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1

提示：
1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
*/

import java.util.HashMap;

public class Solution210126 {
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes.length < 2) return 0;
        //找出所有的骨牌种类和个数（等价牌视为同类）
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int x = dominoes[i][0];
            int y = dominoes[i][1];
            int temp = x < y ? (10 * x + y) : (10 * y + x);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int result = 0;
        for (int num : map.values()) {
            if (num > 1) {
                result += num * (num - 1) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution210126 s = new Solution210126();
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}};
        s.numEquivDominoPairs(dominoes);
    }
}
