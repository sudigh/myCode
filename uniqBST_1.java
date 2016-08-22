/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
REF : Using Dynamic Programming. Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BSTs with the 
specified root i, is the cartesian product of the number of BST for its left and right subtrees. 
*/
public class Solution {
    public int numTrees(int n) {
        int[] total = new int[n+1];
        total[0] = 1;total[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                total[i] += total[j-1]*total[i-j];
            }
        }
        return total[n];
    }
}
