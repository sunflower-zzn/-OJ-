// 12.23
// 387 First Unique Character in a String（字符串第一个唯一字符）

/*
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

    s = "leetcode"
    返回 0

    s = "loveleetcode"
    返回 2

    提示：你可以假定该字符串只包含小写字母。
*/

import java.util.HashMap;

public class Solution201223 {
    public int firstUniqChar(String s) {
        //使用哈希表存放<ch,index>
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                map.put(chs[i], -1);
            } else {
                map.put(chs[i], i);
            }
        }
        int res = chs.length;
        for (int i : map.values()) {
            if (i != -1 && i < res) res = i;
        }
        return res == chs.length ? -1 : res;
    }
}
