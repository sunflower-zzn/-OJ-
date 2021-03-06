// 12.09
// 62 Unique Paths

/*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？

    输入：m = 3, n = 7
    输出：28

    输入：m = 3, n = 2
    输出：3
    解释：
    从左上角开始，总共有 3 条路径可以到达右下角。
    1. 向右 -> 向右 -> 向下
    2. 向右 -> 向下 -> 向右
    3. 向下 -> 向右 -> 向右

    输入：m = 7, n = 3
    输出：28

    输入：m = 3, n = 3
    输出：6
     
    提示：
    1 <= m, n <= 100
    题目数据保证答案小于等于 2 * 109
*/

public class Solution201209 {
    public int uniquePaths(int m, int n) {
/*
        //排列组合A(m-1+n-1,m-1+n-1)/A(m-1,m-1)/A(n-1*n-1)
        //即(m+n-2)!/((m-1)!*(n-1)!)
        int big, small;
        if (m >= n) {
            big = m - 1;
            small = n - 1;
        } else {
            big = n - 1;
            small = m - 1;
        }
        long result = 1;
        for (int i = m + n - 2; i > big; i--) {
            result *= i;
        }
        for (int i = 1; i <= small; i++) {
            result /= i;
        }
        return (int) result;

        //朴素动态规划A[i,j]=A[i-1,j]+A[i,j-1];i>0,j>0
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) A[i][0] = 1;
        for (int j = 0; j < n; j++) A[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                A[i][j] = A[i - 1][j] + A[i][j - 1];
            }
        }
        return A[m - 1][n - 1];
*/

        //优化至1维dp，只需要维护一行，A[j]=A[j]+A[j-1]；旧的A[j]就是上一行的A[i-1,j]
        int[] A=new int[n];
        for(int j=0;j<n;j++)A[j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                A[j]=A[j]+A[j-1];
            }
        }
        return A[n-1];
    }
}
