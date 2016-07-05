public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0,k = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[k++] = nums[j];
            }
            j++;
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
