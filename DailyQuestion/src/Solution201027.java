// 10.27
// 144 Binary Tree Preorder Traversal

/*
    给定一个二叉树，返回它的 前序 遍历。

    Input: root = [1,null,2,3]
    Output: [1,2,3]

    Input: root = []
    Output: []

    Input: root = [1]
    Output: [1]

    Input: root = [1,2]
    Output: [1,2]

    Input: root = [1,null,2]
    Output: [1,2]

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

    进阶：递归算法实现很简单，如果用迭代算法呢？
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution201027 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> preorderlist=new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        /*
        //递归方法
        if(root==null)return preorderlist;
        preorderlist.add(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }
        return preorderlist;
        */

        //迭代方法，用stack维护上一层的根节点，遍历完成后返回
        if(root==null)return new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                preorderlist.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }

        return preorderlist;
    }


}
