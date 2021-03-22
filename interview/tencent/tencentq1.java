/**
 * @Author sunflower_zzn
 * @Date 2021/3/21 20:00
 * @Description
 */
public class tencentq1 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 你需要返回m个指针，第i个指针指向一条链，表示第i个问题的答案
         *
         * @param root TreeNode类 指向链表树的根
         * @param b    int整型一维数组 表示每个问题是什么
         * @return ListNode类一维数组
         */
        public static ListNode[] solve(TreeNode root, int[] b) {
            // write code here
            //暴力遍历如何，深度优先搜索
            ListNode[] res=new ListNode[b.length];
            for(int i=0;i<b.length;i++){
                ListNode head=new ListNode(root.val);
                search(head,root,b[i]);
                res[i]=head.next;
            }
            return res;
        }

        public static Boolean search(ListNode cur, TreeNode root, int n) {
            if (root == null) return false;
            ListNode node = new ListNode(root.val);
            cur.next=node;
            if (root.val == n) {
                return true;
            }
            else{
                if(!search(cur.next,root.left,n) && !search(cur.next,root.right,n)){
                    cur.next=null;
                    return false;
                }
                return true;
            }
        }

        public static void main(String[] args) {
            TreeNode root=new TreeNode(1);
            root.left=new TreeNode(2);
            root.right=new TreeNode(3);
            root.left.left=new TreeNode(4);
            root.left.right=new TreeNode(5);
            root.right.left=new TreeNode(6);
            root.right.right=new TreeNode(7);
            int b[]={1,2,3,4,5};
            solve(root,b);
        }
    }
}
