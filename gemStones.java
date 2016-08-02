/* John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin 
letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once 
in each of the rocks.
Given the list of N rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format
The first line consists of an integer, N , the number of rocks. 
Each of the next N lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Output Format
Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
 
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
        int numRocks = scanner.nextInt(), rocks = 0, count = 0;
        char[] letters = new char[26];
        while (rocks < numRocks) {
            String rck = scanner.next();
            for (int i = 0; i < rck.length(); i++) {
                char c = rck.charAt(i);
                if (letters[c - 'a'] == rocks) { // Count only one occurance in each rock and make sure the character occurs once in each string (letters[c - 'a'] == rocks makes sure that the letter c has occured rocks times before)
                    letters[c - 'a']++;
                    if (letters[c - 'a'] == numRocks) {
                        count++;
                    }
                } 
                
            }
            rocks++;
        }
        System.out.println(count);
    }
}
