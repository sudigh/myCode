public class Solution { // REFERENCE : https://www.youtube.com/watch?v=1ivFSH0ijOM
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, lsi_length = 1;;
        int[] dp = new int[n];
        dp[n-1] = 1;
        for (int i = n-1; i >= 0; i--) {
            ArrayList<Integer> choices = new ArrayList<Integer>();
            choices.add(1);
            int max = 1;
            for (int j = i+1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    choices.add(dp[j]+1);
                    if (dp[j]+1 > max)
                        max = dp[j]+1;
                }
            }
            dp[i] = max;
            if (dp[i] > lsi_length) {
                lsi_length = dp[i];
            }
        }
        return lsi_length;
    }
}
