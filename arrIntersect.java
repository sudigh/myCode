

class Solution {
  public static void main(String[] args) {
    
    int[] arr1 = new int[]{1}, arr2 = new int[]{1,1};
    System.out.println(Arrays.toString(intersection(arr1, arr2)));
  }
  public static int[] intersection(int[] nums1, int[] nums2) {
        //int s1 = nums1.length, s2 = nums2.length;
        List<Integer> inter = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                inter.add(nums2[i]);
                map.remove(nums2[i]);
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
