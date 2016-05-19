/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
 		int levelNodes = 0; 
 		que.add(root);
 		while (!que.isEmpty()) {
 		    levelNodes = que.size();
 		    List<Integer> nodes = new ArrayList<Integer>();
 		    while (levelNodes > 0) {
 		        TreeNode nd = que.poll();
 		        if (nd.left != null)
                    que.offer(nd.left);
                if (nd.right != null)
                    que.offer(nd.right);
                nodes.add(nd.val);
                levelNodes--;
            }
            ret.add(nodes);
 		}
 		return ret;
    }
