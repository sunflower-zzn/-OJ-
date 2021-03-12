// 3.10
// 224. Basic Calculator(基本计算器)

/*
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

输入：s = "1 + 1"
输出：2

输入：s = " 2-1 + 2 "
输出：3

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 
提示：
1 <= s.length <= 3 * 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式
*/

import java.util.Deque;
import java.util.LinkedList;

public class Solution210310 {
    public int calculate(String s) {
        //关键在于字符串解析，用栈实现如何？
        //由于只有加减法，考虑将括号全部展开，每个数变成正数/负数
        int sign = 1; //sign=1,有偶数个负号；sign=-1，有奇数个负号
        Deque<Integer> que = new LinkedList<>();
        que.push(1);
        int res = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -que.peek();
                i++;
            } else if (s.charAt(i) == '+') {
                sign = que.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                que.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                que.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }
}
