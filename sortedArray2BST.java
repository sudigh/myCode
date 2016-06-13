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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return arr2BST(nums, 0, len-1);
    }
    public TreeNode arr2BST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left+right)/2;
        TreeNode curNode = new TreeNode(nums[mid]);
        curNode.left = arr2BST(nums, left, mid-1);
        curNode.right = arr2BST(nums, mid+1, right);
        return curNode;
    }
}
