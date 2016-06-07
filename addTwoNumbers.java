/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0), head;
        head = tmp;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
               carry += l1.val;
               l1 = l1.next;
            }
            if (l2 != null) {
               carry += l2.val;
               l2 = l2.next;
            }
            tmp.val = carry%10;
            carry /= 10;
            if (l1 == null && l2 == null && carry == 0) {
                tmp.next = null;
            } else {
                tmp.next = new ListNode(0);
                tmp = tmp.next;
            }
        }
        return head;
    }
}
