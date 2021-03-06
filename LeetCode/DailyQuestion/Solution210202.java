// 2.2
// 424. Longest Repeating Character Replacement(替换后的最长字符)

/*
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
在执行上述操作后，找到包含重复字母的最长子串的长度。
注意：字符串长度 和 k 不会超过 104。

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
*/

public class Solution210202 {
    //滑动窗口问题
    public int characterReplacement(String s, int k) {
        //维护一个窗口数组，记录当前窗口内各字符出现频率
        int windows[]=new int[26];
        char[] chs=s.toCharArray();
        //定义窗口的左右指针
        int left=0,right=0;
        //窗口中出现过的
        int maxhistory=0;
        for(right=0;right<s.length();right++){
            int index=chs[right]-'A';
            windows[index]++;
            maxhistory=Math.max(maxhistory,windows[index]);
            if(right-left+1>maxhistory+k){
                windows[chs[left]-'A']--;
                left++;
            }
        }
        return s.length()-left;
    }
}
