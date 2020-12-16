// 12.16
// 290 Word Pattern

/*
    给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
    这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

    输入: pattern = "abba", str = "dog cat cat dog"
    输出: true

    输入:pattern = "abba", str = "dog cat cat fish"
    输出: false

    输入: pattern = "aaaa", str = "dog cat cat dog"
    输出: false

    输入: pattern = "abba", str = "dog dog dog dog"
    输出: false
    说明:
    你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
*/

import java.util.HashMap;
import java.util.Map;

public class Solution201216 {
    public boolean wordPattern(String pattern, String s) {
        String[] ss=s.split(" ");
        char[] chs=pattern.toCharArray();
        if(ss.length!=chs.length)return false;
        Map<String,Character> map1=new HashMap<>();
        for(int i=0;i<chs.length;i++){
            if(!map1.containsKey(ss[i])){
                map1.put(ss[i],chs[i]);
            }
            else{
                if(map1.get(ss[i])!=chs[i])return false;
            }
        }
        Map<Character,String> map2=new HashMap<>();
        for(int i=0;i<chs.length;i++){
            if(!map2.containsKey(chs[i])){
                map2.put(chs[i],ss[i]);
            }
            else{
                if(!map2.get(chs[i]).equals(ss[i]))return false;
            }
        }
        return true;
    }
}
