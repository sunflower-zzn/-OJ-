// 3.7
// 131. Palindrome Partitioning(分割回文串Ⅰ)

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

输入：s = "a"
输出：[["a"]]
 
提示：
1 <= s.length <= 16
s 仅由小写英文字母组成
*/

import java.util.ArrayList;
import java.util.List;

public class Solution210307 {
    /*
        回溯法模板
        res = []
        path = []

        def backtrack(未探索区域, res, path):
            if 未探索区域满足结束条件:
                res.add(path) # 深度拷贝
                return
            for 选择 in 未探索区域当前可能的选择:
                if 当前选择符合要求:
                    path.add(当前选择)
                    backtrack(新的未探索区域, res, path)
                    path.pop()
    */

    public List<List<String>> partition(String s) {
        //递归实现
        List<List<String>> res = new ArrayList<>();
        split(s, 0, res, new ArrayList<>());
        return res;
    }

    public void split(String s, int left, List<List<String>> res, List<String> ans) {
        if (s.length() == left) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = left; i < s.length(); i++) {
            if (isParlindrome(s, left, i)) {
                ans.add(s.substring(left, i + 1));
                split(s, i + 1, res, ans);
                ans.remove(ans.size() - 1);
            }
        }

    }

    public boolean isParlindrome(String s, int left, int right) {
        for (int i = left; i <= (right + left) / 2; i++) {
            if (s.charAt(i) != s.charAt(right + left - i)) {
                return false;
            }
        }
        return true;
    }
}
