import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static void printMaxSum(int[] arr){

    // For max continuous sub array
    int max_ending_here = 0;
    //int max_so_far = Integer.MIN_VALUE;
    int max_so_far = arr[0];

    for(int i = 0; i < arr.length; i++){
        max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
        max_so_far = Math.max(max_so_far, max_ending_here);
    }

    System.out.print(max_so_far);

    // For max non-continuous sub array, order doesn't matter
    Arrays.sort(arr);
    int sum = 0;

    // If there is no positive value in entire array, then the last element is the max
    if(arr[arr.length-1] <= 0) {
        sum = arr[arr.length - 1];
    //accumulate all positive values in entire array
    } else {
        for(int x : arr){
            if(x > 0) {
                sum += x;
            }
        }
    }
    System.out.println(" " + sum);
}
 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), idx = 0;
        while (idx < num) {
            int arrLen = scanner.nextInt();
            int[] arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++) {
                arr[i] = scanner.nextInt();
            }
            printMaxSum(arr);
            idx++;
        }
    }
}
