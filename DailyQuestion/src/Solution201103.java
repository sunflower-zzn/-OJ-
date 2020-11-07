// 11.03
// 941 Valid Mountain Array

/*
    给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
        A.length >= 3
        在 0 < i < A.length - 1 条件下，存在 i 使得：
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]

    Input: [2,1]
    Output: false

    Input: [3,5,5]
    Output: false

    Input: [0,3,2,1]
    Output: true

    Note:
    0 <= A.length <= 10000
    0 <= A[i] <= 10000

*/

public class Solution201103 {
    public boolean validMountainArray(int[] A) {
        /*
        if(A.length<3)return false;
        if(A[0]>=A[1])return false;
        boolean haspeek=false;
        for(int i=1;i<A.length;i++){
            if(A[i-1]>A[i])haspeek=true;
            else if(A[i-1]==A[i])return false;   //出现相等为非山峰
            else{
                if(haspeek)return false;  //已经出现山峰的情况下再上扬就为非山脉了
            }
        }
        return haspeek;
        */

        if(A.length<3)return false;
        int left=0;
        int right=A.length-1;
        while(left<A.length-2&&A[left]<A[left+1]){
            left++;
        }
        while(right>0&&A[right-1]>A[right]){
            right--;
        }
        if(left==0||right==A.length-1)return false;
        return left==right;



    }
}
