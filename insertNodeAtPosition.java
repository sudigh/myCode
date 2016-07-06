/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    

Node InsertNth(Node head, int data, int position) {
   // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node tmp = head;
    if (head == null) {
        if (position == 0) {
            head = new Node();
            head.data = data;
            head.next = null;
        }
        return head;
    }
    int idx = 0;
    while (idx < position - 1 && head != null) {
        head = head.next;
        idx++;
    }
    
    if (head != null) {
        Node newNode = new Node();
        newNode.data = data;
        if (position == 0) {
            newNode.next = head;
            head = newNode;            
            tmp = head;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
    }
    return tmp;
}
