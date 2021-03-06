// 12.27
// 205 Isomorphic Strings（同构字符串）

/*
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
*/

import java.util.HashMap;

public class Solution201227 {
    public boolean isIsomorphic(String s, String t) {
        //哈希映射，利用哈希表<Character,Character>
        //注意双向映射都必须一一对应，两个字符不能映射同一个字符
        if (s.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;

/*
       //尝试索引解决，发现运行效率更差了，String查找的效率比HashMap低得多
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.substring(i, i + 1)) != t.indexOf(t.substring(i, i + 1))) {
                return false;
            }
        }*/

    }
}
