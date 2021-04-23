/**
 * @Author sunflower_zzn
 * @Date 2021/4/23 7:52
 * @Description 363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 */
public class Solution210422 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //固定左右边界的情况下，使用dp计算范围内有无符合条件的矩阵范围
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int rowPreSum[] = new int[m];
            for (int r = l; r < n; r++) {
                //每行一个前缀和，表示从l列到r列的前缀和
                for (int row = 0; row < m; row++) {
                    rowPreSum[row] += matrix[row][r];
                }
                //用dp求此时左右边界为l，r时，满足条件的最大值
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < m; i++) {
                    int sum = 0;
                    for (int j = i; j < m; j++) {
                        sum += rowPreSum[j];
                        if (sum > max && sum <= k) max = sum;
                    }
                }
                res = Math.max(res, max);
            }
        }
        return res;
    }
}
