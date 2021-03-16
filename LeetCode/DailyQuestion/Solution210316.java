// 3.16
// 59. Spiral Matrix II(螺旋矩阵Ⅱ)

/*
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

输入：n = 1
输出：[[1]]

提示：
1 <= n <= 20
*/

public class Solution210316 {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int total = n * n;
/*        //1、模拟螺旋
        int top=0,bottom=n-1;
        int left=0,right=n-1;
        int count=1;
        while(count<=total){
            for(int i=left;i<=right;i++){
                res[top][i]=count;
                count++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res[i][right]=count;
                count++;
            }
            right--;
            for(int i=right;i>=left;i--){
                res[bottom][i]=count;
                count++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                res[i][left]=count;
                count++;
            }
            left++;
        }*/

        //2、控制方向
        int dirction[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx=0;
        int count=1;
        int row=0,col=0;
        while(count<=total){
            res[row][col]=count;
            int temprow=row+dirction[dirIdx][0];
            int tempcol=col+dirction[dirIdx][1];
            if(temprow<0 || temprow>=n || tempcol<0|| tempcol>=n || res[temprow][tempcol]>0){
                dirIdx=(dirIdx+1)%4;
            }
            row=row+dirction[dirIdx][0];
            col=col+dirction[dirIdx][1];
            count++;
        }
        return res;
    }
}
