/* You are playing a game on your cell phone. You are given an array of length , indexed from  to . Each element of the array 
is either  or . You can only move to an index which contains . At first, you are at the position. In each move you can do one 
of the following things:

Walk one step forward or backward.
Make a jump of exactly length  forward.
That means you can move from position  to ,  or  in one move, but at least one of the following conditions must be true:

The new position contains 0.
The new position is greater than .
You can't move backward from position . If you move to any position greater than , you win the game.

Given the array and the length of the jump, you need to determine if it's possible to win the game or not.

Input Format

In the first line there will be an integer  denoting the number of test cases. Each test case will consist of two lines. The 
first line will contain two integers,  and . On the second line there will be  space-separated integers, each of which is 
either  or .
Sample Input

4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int m;
    
    private static boolean isSolvable(int[] arr, int idx, HashMap<Integer, Integer> hmap) {
        if (idx < 0 || (hmap.containsKey(idx) && hmap.get(idx) == 1)) return false;
        if ((idx == arr.length - 1) || (idx+m > arr.length - 1)) return true;
        hmap.put(idx, 1);
        return (isSolvable(arr, idx+m, hmap) || isSolvable(arr, idx+1, hmap) || isSolvable(arr, idx-1, hmap));
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt(), count = 0;
        while (count < nTests) {
            HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
            int n = scanner.nextInt();
            m = scanner.nextInt();
            /*if (m > n) {
                System.out.println("YES"); 
                count++;
                continue;
            }*/
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                hmap.put(i, arr[i]);
            }     
            if (isSolvable(arr, 0, hmap) == false) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            count++;
        }
    }
}
