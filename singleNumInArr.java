public class Solution {
    public int singleNumber(int[] nums) {
        int single_num = 0;
        for(int num : nums) {
            single_num ^= num; // XOR the numbers, the number that occurs once gets stored in single_num
        }
        return single_num;
    }
}
