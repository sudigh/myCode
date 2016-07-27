/* DEF : Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
] */
// REF : https://www.youtube.com/watch?v=DxsVoU3_YOo (Using backtracking)

public class Solution {
    public void permutation(List<List<Integer>> list, List<Integer> eachList, int[] nums) {
        if (eachList.size() == nums.length) {
            list.add(new ArrayList<>(eachList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (eachList.contains(nums[i])) continue; // Already visited (fixed character already)
                eachList.add(nums[i]);
                permutation(list, eachList, nums);
                eachList.remove(eachList.size()-1); // Remove the already visited character (fixed character)
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutation(list, new ArrayList<>(), nums);
        return list;
    }
}
