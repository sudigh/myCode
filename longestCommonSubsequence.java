import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 
    public static void LCS_length(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[][] LCS = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            LCS[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            LCS[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1]+1;
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        //System.out.println("Length of LCS : " + LCS[m][n]);
        int idx = LCS[m][n];
        int[] LCsubstr = new int[idx];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (arr1[i-1] == arr2[j-1]) {
                LCsubstr[idx-1] = arr1[i-1];
                //System.out.println(idx + " : " + LCsubstr[idx-1]);
                i--; j--; idx--;
            } else if (LCS[i-1][j] > LCS[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        for (int k = 0; k < LCS[m][n]; k++) {
            System.out.print(LCsubstr[k] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[] arr1 = new int[m], arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = scanner.nextInt();
        }
        //System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        LCS_length(arr1, arr2);
    }
}
