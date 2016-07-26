/* Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for (int nm : nums) { // Populate the HashMap
            hMap.put(nm, hMap.getOrDefault(nm, 0)+1);
        }
        // Form an array of buckets (sorted wrt to index) with frequency as the index and list of numbers as the value.
        List<Integer>[] bks = new List[nums.length+1]; // Should be of length 1 more than array length, as there can be just one element in the array repeated nums.length times.
        for (int key: hMap.keySet()) {
            int freq = hMap.get(key);
            if (bks[freq] == null) {
                bks[freq] = new ArrayList<>(); // Needs to be a list because there can be many keys with the same freq.
            }
            bks[freq].add(key);
        }
        List<Integer> ret = new ArrayList<>();
        for (int freq = bks.length-1; freq >= 0 && ret.size() < k; freq--) {
            if (bks[freq] != null) {
                for(int elem : bks[freq]) {
                    if (ret.size() < k) {
                       ret.add(elem); // Add all of the list elements with this freq to ret till ret size is < k
                    } else {
                        break;
                    }
                }
            }
        } 
        return ret;
    }
}
