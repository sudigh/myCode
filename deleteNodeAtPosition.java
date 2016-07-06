/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 

Node Delete(Node head, int position) {
  // Complete this method
    if (head == null) {
        return head;
    }
    Node tmp = head;
    int idx = 0;
    while (idx < position-1 && head != null) {
        head = head.next;
        idx++;
    }
    if (head != null) {
        if (position == 0) {
            head = head.next;
            tmp = head;
        } else {
            Node toDelete = head.next;
            head.next = toDelete.next;
        }
    }
    return tmp;
}
