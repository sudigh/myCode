/* Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new LinkedList<Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) nums[(nums[i]-1) % len] += len;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) missing.add(i+1);
        }
        return missing;
    }
}
