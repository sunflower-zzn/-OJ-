/**
 * @Author sunflower_zzn
 * @Date 2021/3/30 14:17
 * @Description 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Solution210330 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] > target) return false;
        if (matrix[m - 1][n - 1] < target) return false;
        //两次二分法查找
        //首先二分行，找到对应的行值
        int colidx = binaryRow(matrix, target);
        //然后二分列，找到对应的列值
        return binaryCol(matrix, target, colidx);
    }

    int binaryRow(int[][] matrix, int target) {
        int up = -1;
        int down = matrix.length - 1;
        while (up < down) {
            int mid = (up + down + 1) / 2;
            if (target >= matrix[mid][0]) up = mid;
            else down = mid - 1;
        }
        return up;
    }

    boolean binaryCol(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid]) return true;
            else if (target < matrix[row][mid]) right = mid - 1;
            else if (target > matrix[row][mid]) left = mid + 1;
        }
        return false;
    }
}
