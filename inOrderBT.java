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
        while (root != null) {
            stk.push(root);
            root = root.left;
            while (root == null) {
                if (stk.empty()) {
                    return tree;
                }
                root = stk.pop();
                tree.add(root.val);
                root = root.right;
            }
        }
        return tree;
    }
}
