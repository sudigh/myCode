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
    private List<List<Integer>> allPaths = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<Integer>();
        findAllPaths(path, root, sum);
        return allPaths;
    }
    private void findAllPaths(List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                allPaths.add (path);
            }
            return;
        }
        findAllPaths (new ArrayList<Integer>(path), root.left, sum);
        findAllPaths (new ArrayList<Integer>(path), root.right, sum);
    }
}
