/* Given a sentence S , print if it is a pangram or not(Pangrams are sentences constructed by using every letter 
of the alphabet at least once.)
Input #1

We promptly judged antique ivory buckles for the next prize    
Input #2

We promptly judged antique ivory buckles for the prize    
Sample Output

Output #1

pangram
Output #2

not pangram
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
        String sent = scanner.nextLine();
        sent = sent.replace("\\s+", "").toLowerCase();
        BitSet bits = new BitSet();
        for (char c : sent.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                bits.set(c-'a');
            }
        }
        System.out.println(bits.cardinality()==26?"pangram":"not pangram");
    }
}
