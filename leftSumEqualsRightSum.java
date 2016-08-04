/*
Given an array A of length N, determine if there exists an element in the array such that the sum of the elements on its
left is equal to the sum of the elements on its right. If there are no elements to the left/right, then the sum is considered 
to be zero. 
Formally, find an , such that, A1 + A2 + ... + Ai-1 = Ai+1 + Ai+2 + ... + AN.
Input Format 
The first line contains T , the number of test cases. For each test case, the first line contains N, the number of 
elements in the array . The second line for each test case contains N space-separated integers, denoting the array A.

Output Format 
For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is 
equal to the sum of the elements on its right; otherwise print NO.
Sample Input

2
3
1 2 3
4
1 2 3 3
Sample Output

NO
YES
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt(), count = 0;
        
        while (count < numTests) {
            int arrLen = scanner.nextInt();
            int[] arr = new int[arrLen];
            int rSum = 0, lSum = 0;
            for (int i = 0; i < arrLen; i++) {
                arr[i] = scanner.nextInt();
                rSum += arr[i];
            }
            rSum -= arr[0];
            boolean found = false;
            for (int i = 1; i < arrLen-1; i++) {
                lSum += arr[i-1];
                rSum -= arr[i];
                if (lSum == rSum) {
                    found = true;
                    break;
                }
            }
            if (arrLen == 1) found = true;
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            count++;
        }
    }
}
