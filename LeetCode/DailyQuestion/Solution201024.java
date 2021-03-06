// 10.24 程序员节！
// 1024 视频拼接

/*
    你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
    视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
    我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

    Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
    Output: 3

    Input: clips = [[0,1],[1,2]], T = 5
    Output: -1

    Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
    Output: 3

    Input: clips = [[0,4],[2,8]], T = 5
    Output: 2

    1 <= clips.length <= 100
    0 <= clips[i][0] <= clips[i][1] <= 100
    0 <= T <= 100
*/

public class Solution201024 {
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        int ans = T;
        while (ans > 0) {
            ans = findMaxFormEnd(clips, ans);
            res++;
        }
        if (ans == -1) return -1;
        return res;
    }

    public int findMaxFormEnd(int[][] clips, int ans) {
        int templen = 0;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][1] >= ans) {
                if ((ans - clips[i][0]) > templen) templen = ans - clips[i][0];
            }
        }
        if (templen == 0) return -1;
        return ans - templen;
    }
}
