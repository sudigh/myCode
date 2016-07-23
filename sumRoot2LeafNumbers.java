/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution { // Using recursive pre-order traversal
    public int sumRoot2Leaves(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum*10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return(sumRoot2Leaves(node.left, sum) + sumRoot2Leaves(node.right, sum));
    }
    
    public int sumNumbers(TreeNode root) {
        return sumRoot2Leaves(root, 0);
    }
}
