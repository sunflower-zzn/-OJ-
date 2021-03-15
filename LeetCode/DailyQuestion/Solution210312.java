// 3.12
// 331. Verify Preorder Serialization of a Binary Tree(验证二叉树的前序序列化)

/*
序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true

输入: "1,#"
输出: false

输入: "9,#,#,1"
输出: false
*/

public class Solution210312 {
    public boolean isValidSerialization(String preorder) {
/*        //1.栈+二叉树前序遍历
        //核心：把“x##”变成“#”！！！
        if (preorder == null || preorder.length() == 0) return true;
        Deque<Character> stack = new LinkedList<>();
        String[] str = preorder.split(",");
        int i = 0;
        int n = str.length;
        if (str[0].equals("#")) return n <= 1;
        while (i < n) {
            if (!"#".equals(str[i])) {
                stack.push('d');        //证明是数字，具体是什么不重要
                i++;
            } else {
                if (!stack.isEmpty() && stack.peek() == '#') {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    //这里不能i++，要循环处理当前的栈，看看会不会导致更多的消解！
                } else {
                    stack.push('#');
                    i++;
                }
            }
        }
        //如果是合理二叉树，最后栈里应该只剩下一个#
        return stack.toString().equals("[#]");*/

        //2、计算入度和出度
        //根元素算0个入度和两个出度
        //每一个正常元素算一个入度和两个出度
        //空叶子节点算一个入度和0个出度
        //如果是合理二叉树，那么入度=出度！
        if (preorder == null || preorder.length() == 0) return true;
        String str[] = preorder.split(",");
        int diff = 1;        //diff=出度-入度，对于根节点需要
        for (int i = 0; i < str.length; i++) {
            diff--;
            if (diff < 0) return false;
            if (!str[i].equals("#")) {
                diff += 2;
            }
        }
        return diff==0;
    }

}
