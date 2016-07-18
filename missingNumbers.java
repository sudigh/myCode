import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void findMissingNumbers(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
               map.put(arr1[i], map.get(arr1[i])-1); 
            } else {
               map.put(arr1[i], -1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
               map.put(arr2[i], map.get(arr2[i])+1); 
            } else {
                map.put(arr2[i], 1);
            }
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        for (Object key:keys) {
            int val = map.get(key);
            if (val > 0) {
                System.out.print(key + " ");
            }
            
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int s = in.nextInt(), num = 0, i = 0;
        int[] arr1 = new int[s];
        while (i < s) {
            arr1[i] = in.nextInt(); 
            i++;
        }
        s = in.nextInt(); i = 0;
        int[] arr2 = new int[s];
        while (i < s) {
            arr2[i] = in.nextInt(); 
            i++;
        }
        findMissingNumbers(arr1, arr2);
    }
}
