public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> inter = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                inter.add(nums2[i]);
                int count = map.get(nums2[i])-1;
                if (count == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], count);
                }
                
            }
        }
        int[] ret_arr = new int[inter.size()];
        int i = 0;
        for (Integer num : inter) {
            ret_arr[i++] = num;
        }
        return ret_arr;
    }
}
