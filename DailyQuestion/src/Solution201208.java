// 12.08
// 842 Split Array into Fibonacci Sequence

/*
    给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
    形式上，斐波那契式序列是一个非负整数列表 F，且满足：
    0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
    F.length >= 3；
    对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
    另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
    返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

    输入："123456579"
    输出：[123,456,579]

    输入: "11235813"
    输出: [1,1,2,3,5,8,13]

    输入: "112358130"
    输出: []
    解释: 这项任务无法完成。

    输入："0123"
    输出：[]
    解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。

    输入: "1101111"
    输出: [110, 1, 111]
    解释: 输出 [11,0,11,11] 也同样被接受。

    提示：
    1 <= S.length <= 200
    字符串 S 中只含有数字。
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201208 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res=new ArrayList<>();
        backtrack(S,0,res);
        return res;
    }

    public boolean backtrack(String s,int start,List<Integer> res){
        if(start==s.length()){
            //当start==s.length()时遍历结束，返回能否构建成斐波那契，如果能则res里存放结果
            return res.size()>2;
        }
        long curNum=0;
        for(int i=start;i<s.length();i++){
            //【剪枝】每块数字不能有前导零，除非表示个位数0
            if(s.charAt(start)-'0'==0&&i!=start)break;
            //【剪枝】数字为32为整型范围
            curNum=curNum*10+s.charAt(i)-'0';
            if(curNum>Integer.MAX_VALUE)break;
            //数字要满足斐波那契规则F[i] + F[i+1] = F[i+2]（不足三个时直接加入）
            if(res.size()>=2){
                int pre2NumSum=res.get(res.size()-1)+res.get(res.size()-2);
                //【剪枝】如果大于presum则后面的都会超出，不用再算了
                if((int) curNum>pre2NumSum)break;
                    //如果小于presum，进行下一轮循环
                else if((int) curNum<pre2NumSum)continue;
                //如果恰好等于满足斐波那契规则，进行下一步
            }
            //回溯算法部分，先将当前数字加入res
            res.add((int) curNum);
            //如果后面的递归全部返回false，现在就可以返回true，深入并回溯
            if(backtrack(s,i+1,res)){
                return true;
            }
            //否则当前的拆分不满足条件，remove
            res.remove(res.size()-1);
        }
        return false;
    }
}
