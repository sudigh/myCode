/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) {
            if (nums[i] == i+1 || nums[i] <= 0 || nums[i] > n) i++;
            else if (nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        i = 0;
        while (i < n && nums[i] == i+1) i++;
        return i+1;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
