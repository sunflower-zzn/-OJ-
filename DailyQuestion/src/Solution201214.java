// 12.14
// 49 Group Anagrams

/*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
*/

import java.util.*;

public class Solution201214 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] chs=str.toCharArray();
            Arrays.sort(chs);
            String t= String.valueOf(chs);
            if(map.containsKey(t)){
                map.get(t).add(str);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(t,list);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
