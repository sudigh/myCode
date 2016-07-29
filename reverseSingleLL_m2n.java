/* Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode current = head, prev = null, next = null;
        int k = 1;
        while (k < m && current != null) {
            prev = current;
            current = current.next;
            k++;
        }
        ListNode revHead = prev, revTail = current;
        next = current.next;
        while (k < n && current != null) {
            prev = current;
            current = next;
            next = current.next;
            current.next = prev;
            k++;
        }
        if (revHead != null) {
            revHead.next = current;
        }
        revTail.next = next;
        if (m == 1) {
            head = current;
        }
        return head;
    }
}
