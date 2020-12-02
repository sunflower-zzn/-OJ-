// 11.15
// 402 Remove K Digits

/*
    给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

    注意:
    num 的长度小于 10002 且 ≥ k。
    num 不会包含任何前导零。

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

*/

import java.util.ArrayList;
import java.util.List;

public class Solution201115 {
    public String removeKdigits(String num, int k) {
        //遍历数组，如果比前一位大就可以删除，如果全是升序就删掉最后一位，做k次
        if(num.length()==k)return "0";
        StringBuffer ans=new StringBuffer(num);
        while(k>0){
            int index=0;
            for(int i=1;i<ans.length();i++){
                if(ans.charAt(i)<ans.charAt(i-1))break;
                else index=i;
            }
            ans.deleteCharAt(index);
            k--;
        }
        while(ans.length()>1&&ans.charAt(0)=='0')ans.deleteCharAt(0);
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution201115 s=new Solution201115();
        String num="1432219";
        int k=3;
        s.removeKdigits(num,k);
    }
}
