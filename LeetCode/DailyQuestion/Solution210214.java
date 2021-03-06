// 2.14
// 765. Couples Holding Hands(情侣牵手)

/*
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。

输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。

len(row) 是偶数且数值在 [4, 60]范围内。
可以保证row 是序列 0...len(row)-1 的一个全排列。
*/

public class Solution210214 {
    public int minSwapsCouples(int[] row) {
/*        //贪心，每遇到一个未配对情侣就给他找到对应的人并替换
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            if ((row[i] % 2 == 0 && row[i + 1] == row[i] + 1) || (row[i] % 2 == 1 && row[i + 1] == row[i] - 1))
                continue;
            //默认固定左边的人，给他找右边的人
            if (row[i] % 2 == 0) {
                for (int j = i + 2; j < row.length; j++) {
                    if (row[j] == row[i] + 1) {
                        int temp = row[j];
                        row[j] = row[i + 1];
                        row[i + 1] = temp;
                    }
                }
            } else if (row[i] % 2 == 1) {
                for (int j = i + 2; j < row.length; j++) {
                    if (row[j] == row[i] - 1) {
                        int temp = row[j];
                        row[j] = row[i + 1];
                        row[i + 1] = temp;
                    }
                }
            }
            res++;
        }
        return res;*/

        //并查集
        //输入：每组两人所属index（每对情侣一个index）
        //联通：如果两人属于不同index，进行连通，消耗一个count
        //输出：总index数-count数=最少交换次数
        UnionFind uf = new UnionFind(row.length / 2);
        for (int i = 0; i < row.length; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return row.length / 2 - uf.getCount();
    }

    private class UnionFind {
        int[] parents;      //父节点数组
        int count;          //联通分量

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            count = n;
        }

        public int getCount() {
            return count;
        }

        public int find(int k) {
            while (k != parents[k]) {
                k = parents[k];
            }
            return k;
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parents[rootx] = parents[rooty];
            count--;
        }
    }
}
