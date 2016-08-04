/*
Given N unique integers, count the number of pairs of integers whose difference is K.

Input Format :
The first line contains N and K. 
The second line contains N numbers of the set. All the N numbers are unique.

Output Format :
An integer that tells the number of pairs of integers whose difference is K.
Sample Input :

5 2  
1 5 3 4 2  
Sample Output:

3
Explanation

There are 3 pairs of integers in the set with a difference of 2.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static class Pair {
        int v1;
        int v2;
        public Pair(int a, int b) {
            this.v1 = a; this.v2 = b;
        }
    }
    private static int pairs(int[] a,int k) {
      /* Complete this function */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            }
            if (map.containsKey(a[i]+k)) {
                pairs.add(new Pair(a[i], a[i]+k));
                count++;
            }
            if (map.containsKey(a[i]-k)) {
                pairs.add(new Pair(a[i], a[i]-k));
                count++;
            }
        }       
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
