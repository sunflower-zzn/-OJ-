// 12.20
// 316. Remove Duplicate Letters（去除重复字母）

/*
    给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

    输入：s = "bcabc"
    输出："abc"

    输入：s = "cbacdcbc"
    输出："acdb"

    提示：
    1 <= s.length <= 104
    s 由小写英文字母组成
*/

import java.util.Stack;

public class Solution201220 {
    public String removeDuplicateLetters(String s) {
        //用数组记录每个字符出现的次数
        int[] letter = new int[26];
        for (char ch : s.toCharArray()) {
            letter[ch - 'a']++;
        }
        //维护一个栈，如果遍历到的当前字符小于栈顶元素，就将栈顶出栈，然后放入当前字符
        //否则就直接入栈即可
        //核心思路：贪心算法，每次保证栈之前的内容最优
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.contains(ch)) {
                //如果栈不为空，且ch小于栈顶字符，并且，栈顶字符在ch后面还有
                while (!stack.isEmpty() && ch < stack.peek() && letter[stack.peek() - 'a'] > 0) {
                    stack.pop();
                }
                stack.push(ch);
            }
            letter[ch - 'a']--;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        return res.reverse().toString();
    }
}
