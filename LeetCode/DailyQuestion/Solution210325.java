/**
 * @Author sunflower_zzn
 * @Date 2021/3/25 10:48
 * @Description 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Solution210325 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null) {
            int num = cur.val;
            boolean isRepeat = false;
            while (cur.next!=null && num == cur.next.val) {
                isRepeat = true;
                cur = cur.next;
            }
            if (isRepeat) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return res.next;
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
