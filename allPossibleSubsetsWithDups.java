/* Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
] */

public class Solution {
    private void generateSubsets(List<List<Integer>> list, List<Integer> eachSubset, int[] nums, int start) {
        list.add(new ArrayList<Integer>(eachSubset));
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // Skip duplicates
            eachSubset.add(nums[i]);
            generateSubsets(list, eachSubset, nums, i+1);
            eachSubset.remove(eachSubset.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // So that dups occur in consecutive positions
        generateSubsets(list, new ArrayList<>(), nums, 0);
        return list;
    }
}
