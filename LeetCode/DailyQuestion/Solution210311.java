// 3.11
// 227. Basic Calculator II(基本计算器Ⅱ)

/*
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
整数除法仅保留整数部分。

输入：s = "3+2*2"
输出：7

输入：s = " 3/2 "
输出：1

输入：s = " 3+5 / 2 "
输出：5
 
提示：
1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据保证答案是一个 32-bit 整数
*/

import java.util.Deque;
import java.util.LinkedList;

public class Solution210311 {
    public int calculate(String s) {
        //用preSign处理每次计算（没有括号，无需考虑变号）
        Deque<Integer> nums = new LinkedList<>();
        int res = 0;
        int i = 0;
        int n = s.length();
        char preSign = '+';       //在最前面加一个加号
        int num = 0;
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                switch (preSign) {
                    case '+': {
                        nums.push(num);
                        break;
                    }
                    case '-': {
                        nums.push(-num);
                        break;
                    }
                    case '*': {
                        nums.push(nums.pop() * num);
                        break;
                    }
                    case '/': {
                        nums.push(nums.pop() / num);
                        break;
                    }
                }
            } else {
                if (s.charAt(i) != ' ') preSign = s.charAt(i);
                i++;
            }
        }
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }

}
