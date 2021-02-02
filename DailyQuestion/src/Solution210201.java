// 2.1
// 888. Fair Candy Swap(公平糖果交换)

/*
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。

输入：A = [1,1], B = [2,2]
输出：[1,2]

输入：A = [1,2], B = [2,3]
输出：[1,2]

输入：A = [2], B = [1,3]
输出：[2,3]

输入：A = [1,2,5], B = [2,4]
输出：[5,4]

提示：
1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
保证爱丽丝与鲍勃的糖果总量不同。
答案肯定存在。
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution210201 {
    public int[] fairCandySwap(int[] A, int[] B) {
/*        //暴力法，时间消耗很大n^2复杂度
        int sumA = 0;
        int sumB = 0;
        for (int num : A) {
            sumA += num;
        }
        for (int num : B) {
            sumB += num;
        }
        int diff = sumA - sumB;
        int res[] = new int[2];
        for (int numa : A) {
            for (int numb : B) {
                if (2 * (numa - numb) == diff) {
                    res[0] = numa;
                    res[1] = numb;
                }
            }
        }
        return res;*/

        //利用哈希表把时间复杂度改为n+m
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int diff = sumA - sumB;
        Set<Integer> setB = new HashSet<Integer>();
        for (int num : B) {
            setB.add(num);
        }
        int res[] = new int[2];
        for (int num : A) {
            int reqB = num - (sumA - sumB) / 2;
            if (setB.contains(reqB)) {
                res[0] = num;
                res[1] = reqB;
            }
        }
        return res;
    }
}
