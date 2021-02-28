// 2.27
// 395. Longest Substring with At Least K Repeating Characters(至少有 K 个重复字符的最长子串)

/*
给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。

输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

提示：
1 <= s.length <= 104
s 仅由小写英文字母组成
1 <= k <= 105
*/

public class Solution210227 {
    public int longestSubstring(String s, int k) {
/*
        //滑动窗口法：
        //我们可以枚举最大长度所包含的字符类型数量，答案必然是 [1, 26]，即最少包含 1 个字母，最多包含 26 个字母。
        //你会发现，当确定了长度所包含的字符种类数量时，区间重新具有了二段性质。
        int ans[] = new int[26];
        char ch[] = s.toCharArray();
        int res = 0;
        //当我们使用双指针的时候:(滑动窗口)
        //右端点往右移动必然会导致字符类型数量增加（或不变）
        //左端点往右移动必然会导致字符类型数量减少（或不变）
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(ans, 0);
            // total 代表 [j, i] 区间所有的字符种类数量；sum 代表满足「出现次数不少于 k」的字符种类数量
            for (int i = 0, j = 0, total = 0, sum = 0; i < s.length(); i++) {
                int u = ch[i] - 'a';
                ans[u]++;
                // 如果添加到 ans 之后为 1，说明字符总数 +1
                if (ans[u] == 1) total++;
                // 如果添加到 ans 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
                if (ans[u] == k) sum++;
                while (total > p) {
                    int t = ch[j++] - 'a';
                    ans[t]--;
                    // 如果删除后为 0，说明字符总数-1
                    if (ans[t] == 0) total--;
                    // 如果删除后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
                    if (ans[t] == k - 1) sum--;
                }
                // 当所有字符都符合要求，更新答案
                if (total == sum) res = Math.max(res, i - j + 1);
            }
        }
        return res;*/

        //分治法：
        //对于字符串 ss，如果存在某个字符ch，它的出现次数大于 0 且小于 k，则任何包含ch的子串都不可能满足要求。
        //也就是说，我们将字符串按照ch切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，
        //而不能跨越一个或多个段。因此，可以考虑分治的方式求解本题。
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int split[] = new int[26];
        for (int i = l; i <= r; i++) {
            split[s.charAt(i) - 'a']++;
        }
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (split[i] > 0 && split[i] < k) {
                //以当前字符串中第一个不满足条件的字符类型作为分割字符ch
                ch = (char) (i + 'a');
                break;
            }
        }

        //以下是递归分治部分
        if (ch == 0) {
            //当前字符串中所有字符均满足条件，返回字符串长度
            return r - l + 1;
        }
        int res = 0;
        int p = l;
        while (p <= r) {
            //将l-r用ch拆分
            while (p <= r && s.charAt(p) == ch) {
                p++;
            }
            if (p > r) break;
            int start = p;      //新的左边界
            while (p <= r && s.charAt(p) != ch) {
                p++;
            }
            res = Math.max(res, dfs(s, start, p - 1, k));
        }
        return res;
    }
}
