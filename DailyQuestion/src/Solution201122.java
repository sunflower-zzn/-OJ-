// 11.22
// 242 Valid Anagram

/*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    输入: s = "anagram", t = "nagaram"
    输出: true

    输入: s = "rat", t = "car"
    输出: false

    说明:
    你可以假设字符串只包含小写字母。

    进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution201122 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        /*//做法一：字符串排序后比较
        char[] str_s=s.toCharArray();
        char[] str_t=t.toCharArray();
        Arrays.sort(str_s);
        Arrays.sort(str_t);
        return Arrays.equals(str_s,str_t);*/

        //做法二：字符串记录每种字符出现次数并比较
        int[] table=new int[26];
        for(char c:s.toCharArray()){
            table[c-'a']++;
        }
        for(char c:t.toCharArray()){
            table[c-'a']--;
            if(table[c-'a']<0)return false;
        }
        return true;
    }
}
