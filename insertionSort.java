import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        for (int i = 1; i < ar.length; i++) {
            int val2insert = ar[i], pos = i;
            while (pos > 0 && ar[pos-1] > val2insert) {
                ar[pos] = ar[pos-1];
                pos--;
            }
            ar[pos] = val2insert;
            printArray(ar);
        }
    }  
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    } 
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
