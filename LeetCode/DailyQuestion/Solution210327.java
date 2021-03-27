/**
 * @Author sunflower_zzn
 * @Date 2021/3/27 12:38
 * @Description 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class Solution210327 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        len++;
        int new_k = k % len;    //如果k>len，前进len长度等于不变
        if (new_k == 0) return head;
        cur.next = head;
        cur = head;
        int i = 0;
        while (i < len - new_k - 1) {
            i++;
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
