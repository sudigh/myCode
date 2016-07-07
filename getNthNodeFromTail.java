/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head,int n) {
     // This is a "method-only" submission. 
     // You only need to complete this method. 
    if (head == null) {
        return -1;
    }
    Node first = head, second = head;
    int idx = 0;
    while (idx <= n ) {
        first = first.next;
        idx++;
    }
    while (first != null) {
        second = second.next;
        first = first.next;
    }
    return second.data;
}
