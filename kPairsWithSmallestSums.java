/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
REF : Lets visualize the input as an m×n matrix of sums, for example for nums1=[1,7,11], and nums2=[2,4,6]:

      2   4   6
   +------------
 1 |  3   5   7
 7 |  9  11  13
11 | 13  15  17
The smallest pair is in the top left corner, the one with sum 3. We include that in the pairs of output, 
the next-smaller pair must be the one on the right (sum=5) or the one below (sum=9). Keep a "horizon" of 
possible candidates, implemented as a min priority-queue, and we grow the queue from the top left corner 
towards the bottom right. 
*/
public class Solution {
    public class Pair implements Comparable<Pair> {
        int idx1;
        int idx2;
        int sum;
        
        public Pair(int n1, int n2, int s) {
            this.idx1 = n1;
            this.idx2 = n2;
            this.sum = s;
        }
        
        //@Override
        public int compareTo(Pair x) {
          return this.sum - x.sum;
        } 
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> lst = new LinkedList<int[]>();
        int i = 0, j = 0, count = 0, m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0) return lst;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.offer(new Pair(0, 0, nums1[0]+nums2[0]));
        while (!pq.isEmpty() && count < k) {
            Pair p = pq.poll();
            int[] pair = {nums1[p.idx1], nums2[p.idx2]};
            lst.add(pair); count++;
            if (p.idx2 < n-1) { // Add the next column element
                pq.offer(new Pair(p.idx1, p.idx2+1, nums1[p.idx1]+nums2[p.idx2+1]));
            }
            if (p.idx2 == 0 && p.idx1 < m-1) { // Add the first column of next row element always
                pq.offer(new Pair(p.idx1+1, 0, nums1[p.idx1+1] + nums2[0]));
            }
        }
        return lst;
    }
}
