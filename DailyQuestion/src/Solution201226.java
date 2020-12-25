// 12.26
// 85 Maximal Rectangle（最大矩形）

/*
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

输入：matrix = [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
    ]
输出：6
解释：最大矩形如上图所示。

输入：matrix = []
输出：0

输入：matrix = [["0"]]
输出：0

输入：matrix = [["1"]]
输出：1

输入：matrix = [["0","0"]]
输出：0
 
提示：
rows == matrix.length
cols == matrix[0].length
0 <= row, cols <= 200
matrix[i][j] 为 '0' 或 '1'
*/

public class Solution201226 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
/*
        //暴力算法，计算以当前点为矩形右下角的矩形面积
        //计算一个数组，保存到当前位置连续的1的个数（按行）
        int[][] width = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //计算当前行到当前位置的连续1的个数
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //下面分别以当前点作为矩形右下角，选择不同的高度，计算最大面积
                int squwidth = width[row][col];
                for (int up_row = row; up_row >= 0; up_row--) {
                    squwidth = Math.min(squwidth, width[up_row][col]);
                    res = Math.max(res, squwidth * (row - up_row + 1));
                }
            }
        }
        return res;
*/
        //参考题目84：找出直方图中最大的矩形面积
        //我们可以从上到下依次将当前行作为直方图x轴
        int[] height=new int[matrix[0].length];
        for(int row=0;row<matrix.length;row++){
            // 遍历每一行，构建/更新当前直方图
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]=='1'){
                    height[col]+=1;
                }
                else{
                    height[col]=0;
                }
            }
            //找出当前直方图的最大矩形面积

        }




    }

}
