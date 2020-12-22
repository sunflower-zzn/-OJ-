// 11.12
// 922. Sort Array By Parity II

/*
    给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
    对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
    你可以返回任何满足上述条件的数组作为答案。

    Input: [4,2,5,7]
    Output: [4,5,2,7]
    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

    Note:
    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201112 {
    public int[] sortArrayByParityII(int[] A) {
/*
        //两次遍历，效果很差！
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) even.add(A[i]);
            else odd.add(A[i]);
        }
        int oindex = 0;
        int eindex = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) A[i] = even.get(eindex++);
            else A[i] = odd.get(oindex++);
        }
        return A;
*/

        //双指针法
        int odd = 1, even = 0;
        while (even < A.length) {
            if (A[even] % 2 != 0) {
                while (A[odd] % 2 != 0) {
                    odd += 2;
                }
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
            even += 2;
        }
        return A;
    }

    public static void main(String[] args) {
        Solution201112 s = new Solution201112();
        int[] A = {2, 4, 7, 5};
        s.sortArrayByParityII(A);
    }
}
