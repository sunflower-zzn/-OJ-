// 10.29
// 129 Sum Root to Leaf Numbers

/*
    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

    Input: [1,2,3]
        1
       / \
      2   3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Input: [4,9,0,5,1]
        4
       / \
      9   0
     / \
    5   1
    Output: 1026
    Explanation:
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201029 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        findLeaf(root, res, ans);
        int result = 0;
        for (int i = 0; i < res.size(); i++) {
            result += res.get(i);
        }
        return result;
    }

    public void findLeaf(TreeNode root, List<Integer> res, List<Integer> ans) {
        ans.add(root.val);
        if (root.left == null && root.right == null) {
            long temp = 0;
            for (int i = 0; i < ans.size(); i++) {
                temp += ans.get(i);
                temp *= 10;
            }
            temp /= 10;
            res.add((int) temp);
        }
        if (root.left != null) {
            findLeaf(root.left, res, ans);
        }
        if (root.right != null) {
            findLeaf(root.right, res, ans);
        }
        ans.remove(ans.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(1);
        TreeNode test2 = new TreeNode(2);
        TreeNode test3 = new TreeNode(3);
        test1.left = test2;
        test1.right = test3;
        Solution201029 s = new Solution201029();
        s.sumNumbers(test1);

    }
}
