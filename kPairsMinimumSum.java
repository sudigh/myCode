import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/* DEFINITION : Find K pairs across 2 sorted arrays which have minimum possible sum
ex : // A={1, 2, 4, 5, 6}, B={3, 5, 7, 9} K = 5 result = (1, 3),(2, 3),(1, 5) */
// SOLUTION : // Complexity - O(k logk) time O(k) space. 
//a[] → 1, 2, 4, 5, 6 
//b[] → 3, 5, 7, 9 
//Using PriorityQueue/Max Heap -> take the best element and add its neighbours 
//i.e(a,b): add(1, 3), 
//poll(1,3), add(1, 5), add(2, 3) 
//poll(1,5), add(1,7), add(2, 5) 
//poll(1,7), add(1, 9), add(2, 7)
//etc.... 

class Solution {
  
  static class Pair implements Comparable<Pair>{
    int value;
    int idxA;
    int idxB;
    public Pair(int val,int idxA,int idxB){
      this.value = val;
      this.idxA = idxA;
      this.idxB = idxB;
    }
    
    //@Override
    public int compareTo(Pair x) {
      return this.value - x.value;
    } 
    
    public boolean equals(Object other){
      return ((Pair)other).value==this.value;
    }
    
    public String toString(){
      return "(" + this.idxA +" , "+this.idxB+")";
    }
  }
  
  public void addItem(PriorityQueue<Pair> q, int[] a, int[] b, int idxA, int idxB) {
      if (idxA < a.length && idxB < b.length) {
          q.add(new Pair(a[idxA] + b[idxB], idxA, idxB));
      }
  }
  
  public void findKMinSumPairs(int[] A, int[] B, int k) {
      
      int count = 0, idxA = 0, idxB = 0;
      int len_A = A.length-1, len_B = B.length-1;
      PriorityQueue<Pair> queue = new PriorityQueue<Pair>(10, Collections.reverseOrder());
      addItem(queue, A, B, idxA, idxB);
      
      Pair qPair = null;
      while (true) {
          count++;
          qPair = queue.peek();
        
          if (count == k) {
              break;
          } else { // Add the neighbors
              addItem(queue, A, B, qPair.idxA+1, qPair.idxB);
              addItem(queue, A, B, qPair.idxA, qPair.idxB+1);
          }         
      }
      int n = 0;
      // Put the queue pairs in an array so that we can return the pairs in ascending order
      Pair[] pairs = new Pair[queue.size()];
      while (queue.size() > 0) {
          Pair p = queue.poll();        
          pairs[queue.size()] = p;
          //System.out.println("(" + A[p.idxA] + " , " + B[p.idxB] + ")");
      }
      for(int i = 0; i < k; i++) {
          System.out.println("(" + A[pairs[i].idxA] + " , " + B[pairs[i].idxB] + ")");
          n++;
      }

  }
  
  public static void main(String[] args) {
    int[] arr1 = {1, 4, 7, 10, 16, 18}, arr2 = {2, 3, 8, 12, 15};
    int k = 9;
    Solution sol = new Solution();
    sol.findKMinSumPairs(arr1, arr2, k);
  }  
}
