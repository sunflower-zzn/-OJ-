// 12.15
// 738 Monotone Increasing Digits

/*
    给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
    （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

    输入: N = 10
    输出: 9

    输入: N = 1234
    输出: 1234

    输入: N = 332
    输出: 299
    说明: N 是在 [0, 10^9] 范围内的一个整数。
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201215 {
    public int monotoneIncreasingDigits(int N) {
        //N 属于 [0, 10^9]，记录每一位的逆序
        int[] temp = new int[10];
        int len = 1;
        int num = N;
        while (num >= 10) {
            temp[len - 1] = num % 10;
            len++;
            num = num / 10;
        }
        temp[len - 1] = num;
        //反转temp
        int[] digits = new int[10];
        for (int i = 0; i < len; i++) {
            digits[i] = temp[len - 1 - i];
        }
        //从高位到低位找单调递增序列
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (digits[i] >= digits[index]) {
                index = i;
            } else break;
            ;
        }
        if (index == len - 1) return N;
        //从index开始退一，直到剩下的仍满足
        while (index > 0) {
            if (digits[index] - 1 < digits[index - 1]) {
                index = index - 1;
            } else break;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i < index) {
                res = res * 10 + digits[i];
            } else if (i > index) {
                res = res * 10 + 9;
            } else {
                res = res * 10 + digits[i] - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution201215 s = new Solution201215();
        s.monotoneIncreasingDigits(10);
    }
}
