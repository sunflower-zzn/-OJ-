// 11.27
// 454 4Sum II

/*
    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
    为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

    输入:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]
    输出:
    2

    解释:
    两个元组如下:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*/

import java.util.*;

public class Solution201127 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //不能直接暴力遍历，会出现超时，用哈希映射存放部分加和值以及出现次数
        int res=0;
        Map<Integer,Integer> ab=new HashMap<>();
        for(int num1:A){
            for(int num2:B){
                ab.put(num1+num2,ab.getOrDefault(num1+num2,0)+1);
            }
        }
        for(int num1:C){
            for(int num2:D){
                if(ab.containsKey(-(num1+num2))){
                    res+=ab.get(-(num1+num2));
                }
            }
        }
        return res;
    }
}
