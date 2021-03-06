// 12.26
// 84. Largest Rectangle in Histogram（直方图中最大矩形）【85题前置】

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

输入: [2,1,5,6,2,3]
输出: 10
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class q84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        //其实可以把这个想象成锯木板，如果木板都是递增的那我很开心，如果突然遇到一块木板i矮了一截
        // 那我就先找之前最戳出来的一块（其实就是第i-1块），计算一下这个木板单独的面积，然后把它锯成次高的
        // 这是因为我之后的计算都再也用不着这块木板本身的高度了。再然后如果发觉次高的仍然比现在这个i木板高，
        // 那我继续单独计算这个次高木板的面积（应该是第i-1和i-2块），再把它俩锯短。
        // 直到发觉不需要锯就比第i块矮了，那我继续开开心心往右找更高的。
        // 当然为了避免到了最后一直都是递增的，所以可以在最后加一块高度为0的木板。
        //切木板思路：
        //维护一个单调递增的栈，遍历数组
        //如果当前i高度大于等于栈顶，压栈
        //如果当前i高度小于栈顶，单独计算栈顶柱子的面积（即i-1柱子的面积）
        //然后将栈顶柱子高度减为（i-2）柱子的高度，判断此时栈顶高度是否小于i柱子高度
        //为了最后全部出栈，要在最后插入一个0
/*      int[] new_heights = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) new_heights[i] = heights[i];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < new_heights.length; i++) {
            if (stack.isEmpty() || new_heights[i] >= stack.peek()) {
                stack.push(new_heights[i]);
            } else {
                int width = 1;
                while (!stack.isEmpty() && new_heights[i] < stack.peek()) {
                    res = Math.max(res, stack.peek() * width);
                    stack.pop();
                    width++;
                }
                if (new_heights[i] != 0) {
                    for (int k = 0; k < width; k++) {
                        stack.push(new_heights[i]);
                    }
                }
            }
        }
        return res;
*/
        //优化单调栈，里面只需要存放index，width可以直接相减得出
        //在数组前后各加一个0，用于计算左边界和有边界
        int[] new_heights = new int[heights.length + 2];
        for(int i=0;i<heights.length;i++)new_heights[i+1]=heights[i];
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int left = stack.peek();
                int right = i;
                res = Math.max(res, (right - left - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1};
        q84 s = new q84();
        s.largestRectangleArea(heights);
    }
}
