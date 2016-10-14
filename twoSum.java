/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] two_indices = new int[2];
        Map <Integer, Integer> pair = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (pair.containsKey(target - nums[i])) {
                two_indices[0] = pair.get(target - nums[i]);
                two_indices[1] = i;
                return two_indices;
            }
            pair.put(nums[i], i);
        }
        return two_indices;
    }
}
