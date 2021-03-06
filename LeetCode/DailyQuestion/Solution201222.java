// 12.22
// 103 Binary Tree Zigzag Level Order Traversal（二叉树锯齿状遍历）

/*
    给定一个二叉树，返回其节点值的锯齿形层序遍历。
    （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    例如：
    给定二叉树 [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7

    返回锯齿形层序遍历如下：
    [
      [3],
      [20,9],
      [15,7]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class Solution201222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //做中序遍历，并且根据深度不同记录节点
        treeitor(root, res, 0);
        //锯齿部分逆序即可
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                List<Integer> templist = res.get(i);
                for (int j = 0; j < templist.size() / 2; j++) {
                    int temp = templist.get(j);
                    templist.set(j, templist.get(templist.size() - 1 - j));
                    templist.set(templist.size() - 1 - j, temp);
                }
                res.set(i, templist);
            }
        }
        return res;
    }

    public void treeitor(TreeNode root, List<List<Integer>> list, int deep) {
        if (root != null) {
            if (list.size() < deep + 1) {
                List<Integer> templist = new ArrayList<>();
                templist.add(root.val);
                list.add(templist);
            } else {
                list.get(deep).add(root.val);
            }
            treeitor(root.left, list, deep + 1);
            treeitor(root.right, list, deep + 1);
        }
    }
}
