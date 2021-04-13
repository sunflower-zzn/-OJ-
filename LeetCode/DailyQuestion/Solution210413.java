import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author sunflower_zzn
 * @Date 2021/4/13 13:14
 * @Description 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 */
public class Solution210413 {


    public int minDiffInBST(TreeNode root) {
        //用栈模拟遍历树,[BFS]
        Deque<TreeNode> stack = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (prev != null) {
                min = Math.min(min, Math.abs(prev.val - root.val));
            }
            prev = root;
            root = root.right;
        }
        return min;
    }


    /*
    public List<Integer> midOrder = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        //dfs中序遍历
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < midOrder.size(); i++) {
            min = Math.min(min, midOrder.get(i) - midOrder.get(i - 1));
        }
        return min;
    }

    public void dfs(TreeNode node) {
        //二叉树中序遍历，求最值
        if (node == null) return;
        dfs(node.left);
        midOrder.add(node.val);
        dfs(node.right);
    }*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
