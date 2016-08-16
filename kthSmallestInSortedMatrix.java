/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
REF : Start building a min-heap of Pairs starting with first row. For k-1 times poll the heap(pop the minimum elem)
and insert the element at the next row and same column into the heap.
*/
public class Solution {
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int value;
        
        public Pair(int r, int c, int val) {
            this.row = r;
            this.col = c;
            this.value = val;
        }
        
        //@Override
        public int compareTo(Pair x) {
          return this.value - x.value;
        } 
    }
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int bound = r < k ? r : k;
        for (int i = 0; i < bound; i++) pq.offer(new Pair(0, i, matrix[0][i]));
        for (int i = 1; i < k; i++) {
            Pair p = pq.poll();
            if (p.row == r-1) continue;
            pq.offer(new Pair(p.row+1, p.col, matrix[p.row+1][p.col]));
        }
        return (pq.poll()).value;
    }
}
