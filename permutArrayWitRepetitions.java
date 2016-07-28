/* Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
] */
// REF : https://www.youtube.com/watch?v=0TgbziCDGgw
// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning

public class Solution {
    public void uniqPermutations(List<List<Integer>> list, List<Integer> eachList, int[] nums, boolean[] used) {
        if (eachList.size() == nums.length) {
            list.add(new ArrayList<>(eachList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i-1] == nums[i] && !used[i-1])) continue; // Make sure the first occurance of the repeated character is not used 
                used[i] = true;
                eachList.add(nums[i]);
                uniqPermutations(list, eachList, nums, used);
                used[i] = false;
                eachList.remove(eachList.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        uniqPermutations(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
}
