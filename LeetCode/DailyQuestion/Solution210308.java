// 3.8
// 132. Palindrome Partitioning II(分割回文串Ⅱ)

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
返回符合要求的 最少分割次数 。

输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

输入：s = "a"
输出：0

输入：s = "ab"
输出：1

提示：
1 <= s.length <= 2000
s 仅由小写英文字母组成
*/

import java.util.Arrays;

public class Solution210308 {
    public int minCut(String s) {
        //首先用dp做回文串的预处理，处理后可以在O(1)内确定s[i..j]是不是回文串
        int n = s.length();
        boolean g[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], true);
        }
        //f(i,j)={
        // True,i≥j
        //  f(i+1,j−1)∧(s[i]=s[j]),otherwise
        //          }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    g[i][j] = g[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        //然后处理最小分割次数的问题
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                dp[i] = 0;        //说明0-i是回文串，不用分割
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
