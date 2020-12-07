// 12.07
// 861 Score After Flipping Matrix

/*
    有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
    移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
    在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
    返回尽可能高的分数。

    输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    输出：39
    解释：
    转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
    0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

    提示：
    1 <= A.length <= 20
    1 <= A[0].length <= 20
    A[i][j] 是 0 或 1
*/

public class Solution201207 {
    public int matrixScore(int[][] A) {
        int row=A.length;
        int column=A[0].length;
        //首先将第一列全置为1
        for(int i=0;i<row;i++){
            if(A[i][0]!=1){
                for(int j=0;j<column;j++){
                    A[i][j]=A[i][j]==0?1:0;
                }
            }
        }
        //然后使之后的每一列0的个数小于1的个数
        for(int j=1;j<column;j++){
            int zeronum=0;
            for(int i=0;i<row;i++){
                if(A[i][j]==0)zeronum++;
            }
            if(zeronum>row/2){
                for(int i=0;i<row;i++){
                    A[i][j]=A[i][j]==0?1:0;
                }
            }
        }
        //计算和
        int res= (int) (row*(Math.pow(2,column)-1));
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(A[i][j]==0){
                    res-= (int) (Math.pow(2,column-1-j));
                }
            }
        }
        return res;
    }

}
