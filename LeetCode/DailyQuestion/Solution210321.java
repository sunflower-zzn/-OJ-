/**
 * @Author sunflower_zzn
 * @Date 2021/3/21 15:06
 * @Description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution210321 {
    public void setZeroes(int[][] matrix) {
        //O(mn)：使用一个新的数组，最后再拷贝
        //O(m+n)：使用两个m/n数组记录行和列的清空信息
        //原地算法：利用第一行和第一列作为标记，更新其他列，提前处理第一列和第一行！
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int k = 0; k < m; k++) {
            if (matrix[k][0] == 0) firstColZero = true;
        }
        for (int k = 0; k < n; k++) {
            if (matrix[0][k] == 0) firstRowZero = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int k = 0; k < n; k++) {
                matrix[0][k] = 0;
            }
        }
        if (firstColZero) {
            for (int k = 0; k < m; k++) {
                matrix[k][0] = 0;
            }
        }
    }
}
