/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new LinkedList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        if (root != null) {
            stk.push(root);
        }
        while (!stk.isEmpty()) {
            TreeNode curNode = stk.pop();
            tree.add(curNode.val);
            if (curNode.right != null) {
                stk.push(curNode.right);
            }
            if (curNode.left != null) {
                stk.push(curNode.left);
            }
        }
        return tree;
    }
}
