/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/
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
