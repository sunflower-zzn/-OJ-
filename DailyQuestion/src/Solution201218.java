// 12.18
// 389 Find the Difference

/*
    给定两个字符串 s 和 t，它们只包含小写字母。
    字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    请找出在 t 中被添加的字母。

    输入：s = "abcd", t = "abcde"
    输出："e"
    解释：'e' 是那个被添加的字母。

    输入：s = "", t = "y"
    输出："y"

    输入：s = "a", t = "aa"
    输出："a"

    输入：s = "ae", t = "aea"
    输出："a"

    提示：
    0 <= s.length <= 1000
    t.length == s.length + 1
    s 和 t 只包含小写字母
*/

import java.util.Arrays;

public class Solution201218 {
    public char findTheDifference(String s, String t) {
        /*
        //数组排序
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) return ch2[i];
        }
        return ch2[ch2.length - 1];

        //字符计数法，找到两次相差的那个字符
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[ch1[i] - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            array[ch2[i] - 'a']--;
            if (array[ch2[i] - 'a'] < 0) {
                return ch2[i];
            }
        }
        return ' ';
        */

        //ASCII码求和，相差的值就是不同字符的ASCII码
        int ascii = 0;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for (char ch : ch2) ascii += ch;
        for (char ch : ch1) ascii -= ch;
        return (char) ascii;
    }
}
