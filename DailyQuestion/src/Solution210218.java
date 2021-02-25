// 2.18
// 995. Minimum Number of K Consecutive Bit Flips(K连续位的最小反转次数)

/*
在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。

输入：A = [0,1,0], K = 1
输出：2
解释：先翻转 A[0]，然后翻转 A[2]。

输入：A = [1,1,0], K = 2
输出：-1
解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。

输入：A = [0,0,0,1,0,1,1,0], K = 3
输出：3
解释：
翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 
提示：
1 <= A.length <= 30000
1 <= K <= A.length
*/

public class Solution210218 {
    public int minKBitFlips(int[] A, int K) {
/*        //利用队列模拟滑动窗口，队列中记录需要反转的位置下标
        //条件：len(que) % 2 == A[i]时需要反转
        //i>=que[0]+k,que[0]反转影响不到i了,出队列
        //如果需要反转的i+k>A.length，返回-1
        Deque<Integer> que = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (que.size() > 0 && i >= que.peek() + K) {
                que.poll();
            }
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length) return -1;
                que.offer(i);
                res++;
            }
        }
        return res;*/

        //差分数组，arr[i]表示A[i]-A[i-1]，记录每个位置反转次数的差分数组
        //每次反转需要将i~i+K-1的反转次数+1，但是对于差分数组来说只有arr[i]++和arr[i+K]--
        int arr[] = new int[A.length + 1];
        int res = 0;
        int revCnt = 0;   //反转次数
        for (int i = 0; i < A.length; i++) {
            revCnt += arr[i];
            if (revCnt % 2 == A[i]) {
                if (i + K > A.length) return -1;
                revCnt++;
                arr[i + K]--;
                res++;
            }
        }
        return res;
    }
}
