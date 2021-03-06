// 2.10
// 567. Permutation in String(字符串的排列)

/*
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，第一个字符串的排列之一是第二个字符串的子串。

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").

输入: s1= "ab" s2 = "eidboaoo"
输出: False
 
注意：
输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
通过次数64,567提交次数160,022
*/

import java.util.Arrays;

public class Solution210210 {
    public boolean checkInclusion(String s1, String s2) {
        //滑动窗口，窗口长度s1.length
        //用order数组存放s1的字符组成
        int order[] = new int[26];
        for(char ch:s1.toCharArray()){
            order[ch-'a']++;
        }
        //用cnt数组存放窗口内字符串的字符组成
        int cnt[]=new int[26];
        char chs[]=s2.toCharArray();
        for(int i=0;i<s2.length();i++){
            if(i<s1.length()){
                cnt[chs[i]-'a']++;
            }
            else{
                cnt[chs[i]-'a']++;
                cnt[chs[i-s1.length()]-'a']--;
            }
            if(Arrays.equals(order,cnt))return true;
        }
        return false;
    }
}
