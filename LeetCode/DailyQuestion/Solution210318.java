/**
 * @Author sunflower_zzn
 * @Date 2021/3/18 10:17
 * @Description 92. 反转链表 II
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Solution210318 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode front = new ListNode();
        front.next = head;
        int t = 1;
        while (t < left) {      //front记录left-1位置的node
            front = front.next;
            t++;
        }
        ListNode tail = front.next;     //反转范围的最后一个tail
        front.next = null;
        ListNode cur = tail;
        while (t <= right) {
            ListNode temp = cur.next;
            cur.next = front.next;
            front.next = cur;
            cur = temp;
            t++;
        }
        tail.next = cur;
        if (left == 1) {
            head = front.next;
        }
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
