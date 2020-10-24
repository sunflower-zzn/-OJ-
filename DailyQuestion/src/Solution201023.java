// 10.23
// 234. 回文链表

/*
    Input: 1->2
    Output: false

    Input: 1->2->2->1
    Output: true
*/

// 进一步要求：Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution201023 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;

        /*
        // 使用栈，出栈顺序即为链表逆序，与链表对比即可
        ListNode temp=head;
        Stack<Integer> stack1 = new Stack<>();
        int len=0;
        while(head!=null){
            stack1.push(head.val);
            len++;
            head=head.next;
        }
        for(int i=0;i<len/2;i++){
            if(temp.val!=stack1.pop())return false;
            temp=temp.next;
        }
        return true;
        */

        /*
        // 使用数组存储+双指针法，前后指针相对运行，直到相遇
        List<Integer> list = new ArrayList<Integer>();
        int len=0;
        while(head!=null){
            list.add(head.val);
            head=head.next;
            len++;
        }
        int front=0;
        int end=len-1;
        while(front<end){
            if(!list.get(front).equals(list.get(end)))return false;
            front++;
            end--;
        }
        */

        // 时间复杂度O(n)，空间复杂度O(1)
        // 使用快慢指针确定链表中点，慢指针一次走一步，快指针一次走两步（奇数个节点，中间节点视为前半部分链表）
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // 反转后半部分链表
        ListNode current = slow.next;
        ListNode previous = null;
        ListNode tempnode=current;
        while(current!=null){
            tempnode=current.next;
            current.next=previous;
            previous=current;
            current=tempnode;
        }
        ListNode second_half_reverse_head=previous;
        while(second_half_reverse_head!=null){
            if(head.val!=second_half_reverse_head.val)return false;
            second_half_reverse_head=second_half_reverse_head.next;
            head=head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution201023 p = new Solution201023();
        Solution201023.ListNode head1=p.new ListNode(1);
        Solution201023.ListNode node1=p.new ListNode(2);
        Solution201023.ListNode head2=p.new ListNode(1);
        Solution201023.ListNode node2=p.new ListNode(2);
        Solution201023.ListNode node3=p.new ListNode(2);
        Solution201023.ListNode node4=p.new ListNode(1);

        head1.next=node1;
        head2.next=node2;
        node2.next=node3;
        node3.next=node4;

        System.out.println(p.isPalindrome(head1));
        System.out.println(p.isPalindrome(head2));
    }
}
