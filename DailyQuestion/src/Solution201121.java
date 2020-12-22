// 11.21
// 148 Sort List

/*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

    进阶：
    你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

    Input: head = [4,2,1,3]
    Output: [1,2,3,4]

    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]

    Input: head = []
    Output: []

    提示：
    链表中节点的数目在范围 [0, 5 * 104] 内
    -105 <= Node.val <= 105
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution201121 {
    public class ListNode {
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

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        list.sort((Comparator.comparingInt(o -> o)));
        temp = head;
        for (int num : list) {
            temp.val = num;
            temp = temp.next;
        }
        return head;
    }
}
