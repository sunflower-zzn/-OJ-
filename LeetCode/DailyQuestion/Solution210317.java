/**
 * @Author sunflower_zzn
 * @Date 2021/3/17 9:07
 * @Description 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 */
public class Solution210317 {
/*    int memo[][];


    public int numDistinct(String s, String t) {
        //记忆化搜索，暴力递归会超时
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return subseq(s, 0, t, 0);
    }

    public int subseq(String s, int s_idx, String t, int t_idx) {
        if (t_idx == t.length()) {
            return 1;
        }
        if (s_idx == s.length()) {
            return 0;
        }
        //设置一个剪枝条件，如果剩余t长度比剩余s长度长的话一定不匹配
        if (s.length() - s_idx < t.length() - t_idx) return 0;
        //记忆化判断
        if (memo[s_idx][t_idx] != -1) return memo[s_idx][t_idx];
        //递归
        if (s.charAt(s_idx) == t.charAt(t_idx)) {
            memo[s_idx][t_idx] = subseq(s, s_idx + 1, t, t_idx + 1) + subseq(s, s_idx + 1, t, t_idx);
        } else {
            memo[s_idx][t_idx] = subseq(s, s_idx + 1, t, t_idx);
        }
        return memo[s_idx][t_idx];
    }*/

    public int numDistinct(String s, String t) {
        //动态规划思路
        //dp[i][j]；表示s[i:s.len]中t[j:t.len]字符串的子序列个数
        //所以dp[0][0]就是最终要求的结果
        if (s.length() < t.length()) return 0;
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char sc = s.charAt(i);
            for (int j = t.length() - 1; j >= 0; j--) {
                char tc = t.charAt(j);
                if (sc == tc) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
