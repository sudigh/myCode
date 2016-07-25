import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    Stack<Integer> queue = new Stack<Integer>(); // Stores in FILO order
    Stack<Integer> temp = new Stack<Integer>(); // Stores in FIFO order
  
    public void push(int num) {
        temp.push(num);
    }
    
    public void remove() {
        if (queue.isEmpty()) {
            while (!temp.isEmpty()) {
                queue.push(temp.pop());
            }
        } 
        if (!queue.isEmpty()) {
            queue.pop();
        }
    }
  
    public int peek() {
        if (queue.isEmpty()) {
            while (!temp.isEmpty()) {
                queue.push(temp.pop());
            }
        } 
        
        return queue.peek();
    }
  
    public boolean empty() {
        if (queue.isEmpty() && temp.isEmpty()) {
            return true;
        }
        return false;
    }
  
    public void printQueue() {
        
        Stack<Integer> stk = new Stack<Integer>();
        
        while (!queue.isEmpty()) {
            int num = queue.pop();
            System.out.print(num + " ");
            stk.push(num);
        }
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
        while (!queue.isEmpty()) {
            int num = queue.pop();
            System.out.print(num + " ");
            stk.push(num);
        }
        while (!stk.isEmpty()) {
            queue.push(stk.pop());
        }
        System.out.println();
    }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.push(9); sol.push(7); sol.push(4); sol.push(12); sol.push(5);
    sol.printQueue();
    System.out.println("Peek " + sol.peek()); 
    sol.remove();
    System.out.println("Peek " + sol.peek());
    sol.push(20);
    sol.printQueue();
    sol.remove();
    sol.printQueue();
  }  
}
