/* Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    
    public void generateSubsets(List<List<Integer>> list, List<Integer> eachSubset, int[] nums, int start) {
        list.add(new ArrayList<>(eachSubset));
        for (int i = start; i < nums.length; i++) {
            eachSubset.add(nums[i]);
            generateSubsets(list, eachSubset, nums, i+1);
            eachSubset.remove(eachSubset.size()-1);
        }
    }  
     
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generateSubsets(list, new ArrayList<>(), nums, 0);
        return list;
    }
}
