// 2.12
// 119. Pascal's Triangle II(杨辉三角Ⅱ)

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？
*/

import java.util.ArrayList;
import java.util.List;

public class Solution210212 {
    public List<Integer> getRow(int rowIndex) {
        //杨辉三角第k行等于Ak展开式
        List<Integer> list = new ArrayList<>();
        long temp = 1;
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            temp = temp * (rowIndex - i) / (i + 1);
            list.add((int) temp);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution210212 s = new Solution210212();
        s.getRow(13);
    }
}
