public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       if (nums.length == 0 || k <= 0) {
           return nums;
       } 
       LinkedList<Integer> dque = new LinkedList<>();
       int[] result = new int[nums.length-k+1];
       for (int i = 0; i < nums.length; i++) {
           if (!dque.isEmpty() && (dque.peek() < i-k+1)) { // If last index in the dque is below current window indices, then pop out that index because it does not belong to the current window.
               dque.poll();
           }
           while(!dque.isEmpty() && (nums[i] >= nums[dque.peekLast()])) {
               dque.pollLast(); // Get rid of numbers that are smaller than nums[i]
           }
           dque.offer(i);
           if (i-k+1 >= 0) {
               result[i-k+1] = nums[dque.peek()];
           }
       }
       return result;
    }
}
