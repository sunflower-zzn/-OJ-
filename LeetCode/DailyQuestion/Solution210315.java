// 3.15
// 54. Spiral Matrix(螺旋矩阵)

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class Solution210315 {
    public List<Integer> spiralOrder(int[][] matrix) {
/*        //1、按层遍历，每次遍历最外面一圈
        int row = matrix.length;
        int col = matrix[0].length;
        int eleNum = row * col;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = col - 1;
        int top = 0, bottom = row - 1;
        while (eleNum > 0) {
            for (int i = left; i <= right && eleNum > 0; i++) {
                res.add(matrix[top][i]);
                eleNum--;
            }
            top++;
            for (int i = top; i <= bottom && eleNum > 0; i++) {
                res.add(matrix[i][right]);
                eleNum--;
            }
            right--;
            for (int i = right; i >= left && eleNum > 0; i--) {
                res.add(matrix[bottom][i]);
                eleNum--;
            }
            bottom++;
            for (int i = bottom; i >= top && eleNum > 0; i--) {
                res.add(matrix[i][left]);
                eleNum--;
            }
            left++;
        }
        return res;*/

        //2、辅助数组判断是否访问过，再通过规律的方向转移（右下左上）设置一个策略数组
        int row = matrix.length;
        int col = matrix[0].length;
        int eleNum = row * col;
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int stepIdx = 0;
        int i = 0, j = 0;
        for (int num = 0; num < eleNum; num++) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            int ti = i + steps[stepIdx][0];
            int tj = j + steps[stepIdx][1];
            if (ti < 0 || ti >= row || tj < 0 || tj >= col || visited[ti][tj]) {
                stepIdx = (stepIdx + 1) % 4;
            }
            i = i + steps[stepIdx][0];
            j = j + steps[stepIdx][1];
        }
        return res;
    }
}
