// 11.30
// 767 Reorganize String

/*
    给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
    若可行，输出任意可行的结果。若不可行，返回空字符串。

    输入: S = "aab"
    输出: "aba"

    输入: S = "aaab"
    输出: ""

    注意:
    S 只包含小写字母并且长度在[1, 500]区间内。
*/

import java.util.HashMap;
import java.util.Map;

public class Solution201130 {
    public String reorganizeString(String S) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:S.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            else{
                map.put(ch,map.get(ch)+1);
            }
        }
        int maxnum=0;
        for(char ch:S.toCharArray()){
            if(map.get(ch)>maxnum){
                maxnum=map.get(ch);
            }
        }
        //return maxnum>S.length()/2;
        return "";
    }
}
