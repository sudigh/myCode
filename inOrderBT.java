/* Gi
*/ven a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new LinkedList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        if (root == null) {
            return tree;
        }
        TreeNode curr = root;
        while (curr != null || !stk.empty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            tree.add(curr.val);
            curr = curr.right;
        }
        return tree;
    }
}
