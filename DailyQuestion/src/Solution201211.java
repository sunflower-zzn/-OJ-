// 12.11
// 649 Dota2 Senate

/*
    Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
    Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
    禁止一名参议员的权利：
    参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
    宣布胜利：
              如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
    给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
    以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
    假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。

    输入："RD"
    输出："Radiant"
    解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人

    输入："RDD"
    输出："Dire"
    解释：
    第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
    第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
    第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
    因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利

    提示：
    给定字符串的长度在 [1, 10,000] 之间.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution201211 {
    public String predictPartyVictory(String senate) {
        /*
        //非常笨的循环方案
        List<Character> list=new ArrayList<>();
        int R_num=0;
        int D_num=0;
        for(char ch : senate.toCharArray()){
            if(ch=='R')R_num++;
            else D_num++;
            list.add(ch);
        }
        while(R_num>0&&D_num>0){
            int index=0;
            while(index<list.size()){
                if(list.get(index)=='R'){
                    if(list.indexOf('D')==-1){
                        if(list.indexOf('d')==-1)break;
                        else list.remove(Character.valueOf('d'));
                        index--;
                    }
                    else{
                        list.remove(Character.valueOf('D'));
                    }
                    D_num--;
                    list.set(index,'r');
                    index++;
                }
                else{
                    if(list.indexOf('R')==-1){
                        if(list.indexOf('r')==-1)break;
                        else list.remove(Character.valueOf('r'));
                        index--;
                    }
                    else{
                        list.remove(Character.valueOf('R'));
                    }
                    R_num--;
                    list.set(index,'d');
                    index++;
                }
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i)=='r')list.set(i,'R');
                if(list.get(i)=='d')list.set(i,'D');
            }
        }

        if(R_num>0)return "Radiant";
        else return "Dire";
        */

        //优化后的循环方案，用两个栈来分别保存两方的参议员
        //队列中的值表示顺序+轮次*长度
        //每次执行完权力后就出队列，并放到最后
        //如果被ban的话就直接对方参议员出队列
        //直到某一个队列为空
        Queue<Integer> radiantQueue=new LinkedList<Integer>();
        Queue<Integer> direQueue=new LinkedList<Integer>();
        //队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
        //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
        char[] chs=senate.toCharArray();
        int len=chs.length;
        for(int i=0;i<len;i++){
            if(chs[i]=='D'){
                direQueue.offer(i);
            }
            else{
                radiantQueue.offer(i);
            }
        }
        while(direQueue.size()>0&&radiantQueue.size()>0){
            if(direQueue.peek()<radiantQueue.peek()){
                radiantQueue.poll();
                int t=direQueue.poll();
                direQueue.offer(t+len);
            }
            else {
                direQueue.poll();
                int t=radiantQueue.poll();
                radiantQueue.offer(t+len);
            }
        }
        if(radiantQueue.size()>0)return "Radiant";
        else return "Dire";
    }
}

