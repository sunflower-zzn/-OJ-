// 11.20
// 147 Insertion Sort List

/*
    对链表进行插入排序。
    插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

    插入排序算法:
    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。

    Input: 4->2->1->3
    Output: 1->2->3->4

    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
*/

public class Solution201120 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode previous=head;
        while(previous.next!=null){
            if(head.val>=previous.next.val){
                ListNode temp=previous.next;
                previous.next=temp.next;
                temp.next=head;
                head=temp;
            }
            else{
                ListNode p=head;
                while(p!=previous&&p.next.val<previous.next.val){
                    p=p.next;
                }
                if(p==previous)previous=previous.next;
                else{
                    ListNode temp=previous.next;
                    previous.next=temp.next;
                    temp.next=p.next;
                    p.next=temp;
                }
            }
        }
        return head;
    }
}
