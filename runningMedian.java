/*
Given an input stream of n integers, you must perform the following task for each ith integer:

Add the ith integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the ith element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled to 1
decimal place (i.e., 12.3 format).
Sample Input

6
12
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner in = new Scanner(System.in);
    // maxHeap stores the lower valued integers, minHeap stores the higher valued integers.
    PriorityQueue maxHeap = new PriorityQueue(10, Collections.reverseOrder());
    PriorityQueue minHeap = new PriorityQueue();

    int n = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    System.out.println((double)a);
    System.out.println((double)((double)a+(double)b)/(double)2);

    maxHeap.add(Math.min(a,b));
    minHeap.add(Math.max(a,b));

    Integer midInt = null;
    for(int i = 2; i < n; i++) {
        int currInt = in.nextInt();

        if (i%2 == 0) { // when i is even, it is the odd-th element
            //even : maxHeap < minHeap
            //balanced (minHeap.size() == maxHeap.size())
            if(currInt < (int)maxHeap.peek()){
                maxHeap.add(currInt);
                midInt = (Integer)maxHeap.remove();
            } else if(currInt > (int)minHeap.peek()) {
                minHeap.add(currInt);
                midInt = (Integer)minHeap.remove();
            } else {
                midInt = currInt;
            }
            System.out.println((double)midInt);
        } else {

            Integer tmpMidInt = null;
            //odd : maxHeap < midIdx < minHeap
            if(currInt < (int)maxHeap.peek()){
                tmpMidInt = (Integer)maxHeap.remove();
                maxHeap.add(currInt);
            }else if(currInt > (int)minHeap.peek()){
                tmpMidInt = (Integer)minHeap.remove();
                minHeap.add(currInt);
            }else{
                tmpMidInt = currInt;
            }

            System.out.println((double)(midInt+tmpMidInt)/(double)2);

            maxHeap.add(Math.min(midInt.intValue(),tmpMidInt.intValue()));
            minHeap.add(Math.max(midInt.intValue(),tmpMidInt.intValue()));
            midInt = null;
        }
    }
  }
}
