/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /** Use leader and trailer pointers. The leader pointer is n steps ahead of the trailer pointer. 
 When the leader reaches the end, the trailer pointer points at the previous element of the target element. **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trailer = head, leader = head;
        for (int i = 0; i < n; i++) {
            leader = leader.next;
        }
        if (leader == null) { // If there is only 1 node in the list
            head = head.next;
            return head;
        }
        while (leader.next != null) {
            trailer = trailer.next;
            leader = leader.next;
        }
        trailer.next = trailer.next.next;
        return head;
    }
}
