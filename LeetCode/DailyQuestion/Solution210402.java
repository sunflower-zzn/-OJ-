import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author sunflower_zzn
 * @Date 2021/4/2 12:41
 * @Description 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution210402 {
/*    //解法一：按列求，暴力算法，每个位置找左右最高的位置，然后算可存的水位
    //时间复杂度 O(n^2)
    public int trap(int[] height) {
        int res = 0;
        //第一个和最后一个位置不能蓄水，不考虑
        for (int i = 1; i < height.length - 1; i++) {
            int leftmax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftmax = Math.max(leftmax, height[j]);
            }
            int rightmax = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length; j++) {
                rightmax = Math.max(rightmax, height[j]);
            }
            int edge = Math.min(leftmax, rightmax);
            if (height[i] < edge) {
                res += edge - height[i];
            }
        }
        return res;
    }*/

/*    //解法二：按列求，动态规划，预先求出每个位置左右最高的木板高度
    //减少了重复计算，时间复杂度 O(n)
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int res = 0;
        //第一个和最后一个位置不能蓄水，不考虑
        //每个位置左右木板高度
        int dp[][] = new int[height.length][2];
        //左边遍历一遍
        int leftmax = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            dp[i][0] = leftmax;
            leftmax = Math.max(leftmax, height[i]);
        }
        //右边遍历一遍
        int rightmax = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            dp[i][1] = rightmax;
            rightmax = Math.max(rightmax, height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int edge = Math.min(dp[i][0], dp[i][1]);
            if (height[i] < edge) {
                res += edge - height[i];
            }
        }
        return res;
    }*/

/*    //解法三：按列求，双指针法，每次只需要考虑左右两边比较矮的柱子高度即可
    //左边的会优先左边的，右边的会优先右边的
    //每次把更矮的柱子向中间移动
    //时间复杂度 O(N)
    public int trap(int[] height) {
        int res = 0;
        //第一个和最后一个位置不能蓄水，不考虑
        int left = 0, right = height.length - 1;
        int lmax = 0, rmax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < lmax) {
                    res += lmax - height[left];
                } else {
                    lmax = height[left];
                }
                left++;
            } else {
                if (height[right] < rmax) {
                    res += rmax - height[right];
                } else {
                    rmax = height[right];
                }
                right--;
            }
        }
        return res;
    }*/

/*    //解法四：按行求，从底部到顶部，每一层的面积和 减去柱子本身即可！
    //双指针，每次把左右的行计算入内
    //时间复杂度 O(N)
    public int trap(int[] height) {
        int res = 0;
        int sum = 0;
        int curHeight = 1;  //遍历到第几层了
        int left = 0, right = height.length - 1;
        //由于最中间的也含有体积，所以条件注意要设置为left<=right
        while (left <= right) {
            while (left <= right && height[left] < curHeight) {
                sum += height[left++];
            }
            while (left <= right && height[right] < curHeight) {
                sum += height[right--];
            }
            res += right - left + 1;
            curHeight++;
        }
        return res - sum;
    }*/

    //解五：按行求，单调栈（单调递减）
    //如果当前元素大于栈顶，且栈大小>1，那么就说明存在一个可以存水的空间
    //范围stack[left]-->stack[top]<--height[cur]
    //而这实际上就是对于每一块存水区，按行处理了！
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        int idx = 0;
        while (idx < height.length) {
            while (!stack.isEmpty() && height[idx] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int len = idx - left - 1;
                int curheight = Math.min(height[left], height[idx]) - height[top];
                res += len * curheight;
            }
            stack.push(idx++);
        }
        return res;
    }
}
