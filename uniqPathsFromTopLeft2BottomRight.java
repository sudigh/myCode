/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.
REF : Total number of moves to go from top-left to bottom-right corner is (m+n-2). Number of downward moves is m-1. Therefore 
number of ways to go from top-left to bottom-right is (m+n-2)C(m-1). Link : https://www.youtube.com/watch?v=M8BYckxI8_U
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2, k = Math.min(m-1, n-1);
        long total = 1;
        for (int i = 1; i <= k; i++) {
            total = total*(N-i+1)/i;
        }
        return (int)total;
    }
}
