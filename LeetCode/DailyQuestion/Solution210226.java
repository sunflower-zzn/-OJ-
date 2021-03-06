// 2.26
// 1178. Number of Valid Words for Each Puzzle(猜字谜)

/*
外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
单词 word 中包含谜面 puzzle 的第一个字母。
单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。

输入：
words = ["aaaa","asas","able","ability","actt","actor","access"],
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
输出：[1,1,3,2,4,0]
解释：
1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。

提示：
1 <= words.length <= 10^5
4 <= words[i].length <= 50
1 <= puzzles.length <= 10^4
puzzles[i].length == 7
words[i][j], puzzles[i][j] 都是小写英文字母。
每个 puzzles[i] 所包含的字符都不重复。
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution210226 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> list = new LinkedList<>();
        //使用二进制压缩法统计words类型，一共26个字母，出现为1，不出现为0，用一个26位二进制数作为键，出现频率作为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp = temp | (1 << s.charAt(j) - 'a');     //出现位置标为1
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        //谜面的长度一定为7，并且首位必须有，所以每个谜面对应的谜底子集种类有2^6=128种，然后再找里面包含几个word即可
        for (String s : puzzles) {
            int temp = 0;     //puzzles对应的二进制数值
            for (int i = 0; i < s.length(); i++) {
                temp = temp | (1 << s.charAt(i) - 'a');
            }
            int cnt = 0;//匹配的word数量
            //枚举子集
            for (int j = temp; j != 0; j = (j - 1) & temp) {
                if ((1 << (s.charAt(0) - 'a') & j) != 0) {
                    cnt += map.getOrDefault(j, 0);
                }
            }
            list.add(cnt);
        }
        return list;
    }
}
