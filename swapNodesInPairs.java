/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next, aNode = head, bNode = aNode.next, preNode = null;
        while(bNode != null) {
            aNode.next = bNode.next;
            bNode.next = aNode;
            if (preNode != null) {
                preNode.next = bNode;
            }
            preNode = aNode;
            aNode = aNode.next;
            if (aNode != null) {
                bNode = aNode.next;
            } else {
                bNode = aNode;
            }
        }
        return newHead;
    }
}
