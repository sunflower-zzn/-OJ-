// 11.11
// 514 Freedom Trail

/*
    视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
    给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
    最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
    旋转 ring 拼出 key 字符 key[i] 的阶段中：

    您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
    如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。

    输入: ring = "godding", key = "gd"
    输出: 4
    解释:
     对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
     对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
     当然, 我们还需要1步进行拼写。
     因此最终的输出是 4。
    提示：
    ring 和 key 的字符串长度取值范围均为 1 至 100；
    两个字符串中都只有小写字符，并且均可能存在重复字符；
    字符串 key 一定可以由字符串 ring 旋转拼出。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution201111 {
    public int findRotateSteps(String ring, String key) {
        //动态规划
        // dp[i][j] 表示 考虑 key 的 前 i+1 个字符 [0..i] 时，当前字符 key[i] 在 ring 中的下标 j 需要的 最小步数
        /*
            【状态转移方程】  当前字符 c 的位置 j, 上一个字符 last 的位置 k
            dp[i][j] = min(dp[i-1][k] + dis(k,j))
            其中 dis(k, j) 表示 在转盘上从 k 转到 j 的最小步数
            对于钟表，1点到2点 的步数 可以是 |1-2| = 1，也可以是 12(总刻度数) - 1 = 11, 最小步数是 1，依次类推。
        */
        // 维护一个list数组，list记录ring中每种字符出现的位置，并根据字符大小（a-z）记录到list数组中
        List<Integer>[] pos=new List[26];
        for(int i=0;i<26;i++){
            pos[i]=new ArrayList<Integer>();
        }
        int n=ring.length(),m=key.length();
        for(int i=0;i<n;i++){
            pos[ring.charAt(i)-'a'].add(i);
        }
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for(int i=1;i<m;i++){
            for(int j:pos[key.charAt(i)-'a']){
                for(int k:pos[key.charAt(i-1)-'a']){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][k]+Math.min(Math.abs(j-k),n-Math.abs(j-k))+1);
                }
            }
        }
        return Arrays.stream(dp[m-1]).min().getAsInt();
    }

}
