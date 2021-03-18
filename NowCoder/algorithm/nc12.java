/*
题目描述:
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

输入
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
返回值
{1,2,5,3,4,6,7}
*/

import java.util.Arrays;

public class nc12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return rebuild(0, pre.length - 1, 0, in.length - 1, pre, in);
        }

        //递归实现重建二叉树
        TreeNode rebuild(int preL, int preR, int inL, int inR, int[] pre, int[] in) {
            //递归终止条件
            if (preL > preR) return null;
            TreeNode root = new TreeNode(pre[preL]);
            for (int i = inL; i <= inR; i++) {
                if (in[i] == root.val) {    //in[inL]为当前范围的根节点值，左右递归处理
                    root.left = rebuild(preL + 1, preL + i - inL, inL, i - 1, pre, in);
                    root.right = rebuild(preL + i - inL + 1, preR, i + 1, inR, pre, in);
                    break;
                }
            }
            return root;
        }
    }
}
