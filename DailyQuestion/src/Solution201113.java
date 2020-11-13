// 11.13
// 328 Odd Even Linked List

/*
    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL

    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL

    说明:
    应当保持奇数节点和偶数节点的相对顺序。
    链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
*/

public class Solution201113 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode odd=head;              //当前已排序奇数序列的尾节点
        ListNode even=head.next;        //当前已排序偶数序列的尾节点
        while(even!=null && even.next!=null){   //length为奇数时，even==null，length为偶数时，even.next==null
            ListNode nextodd=even.next;
            ListNode nexteven=even.next.next;
            nextodd.next=odd.next;
            odd.next=nextodd;
            odd=nextodd;
            even.next=nexteven;
            even=nexteven;
        }
        return head;
    }
}
