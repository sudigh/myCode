import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
   public class ListNode {
     int val;
     ListNode next;
     //void ListNode();
     ListNode(int x) { val = x; }
  }
  private static LinkedList<ListNode> ll;
  private  ListNode root;
  
  public void formLLFromNum(int num) {
      ll = new LinkedList<ListNode>();
      ListNode node = new ListNode(0);
      node.next = null;
      
      int quotient = num/10, reminder = num%10;
      while (true) {
         System.out.println("quotient : " + quotient + " reminder : " + reminder);
         node.val = reminder;
         reminder = quotient % 10;
         quotient = quotient/10;  
         if (quotient > 0 || reminder > 0) {
           ListNode nNode = new ListNode(0);
           nNode.next = node;
           node = nNode;
         } else {
           break;
         }
      }
      root = node;
  }
  
  public void printList(ListNode root) {
    
    System.out.println("-------------");
    while (root != null) {
      System.out.print(root.val);
      root = root.next;
    }
    System.out.println();
  }
  
  public ListNode plusOne(ListNode root) {
      // First reverse the list
      ListNode head = null, current = root;
      while (current != null) {
          ListNode tmp = current;
          current = current.next;
          tmp.next = head;
          head = tmp;
      }
      // Now add 1 and reverse the list again simultaneously
      int carry = 1;
      current = head;
      head = null;
      while (current != null) {
          int sum = current.val+carry;
          current.val = sum%10;
          carry = sum/10;
          System.out.println("carry : " + carry);
          ListNode tmp = current;
          current = current.next;
          tmp.next = head;  
          head = tmp;
      }
      if (carry != 0) {
          ListNode newHead = new ListNode(carry);
          newHead.next = head;
          root = newHead;
          System.out.println("root.val " + root.val);
      } else {
        root = head;
      }
      //printList(root);
      return root;
  }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.formLLFromNum(989);
    sol.printList(sol.root);
    sol.root = sol.plusOne(sol.root); 
    sol.printList(sol.root);
  }  
}
