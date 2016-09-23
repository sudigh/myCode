/*
Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
*/
import java.util.*;

class Solution{
   private static Deque<Character> stk = new ArrayDeque<Character>();
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
          String input=sc.next();
            //Complete the code
          stk.clear();
          boolean fail = false;
          for (int i = 0; !fail && i < input.length(); i++) {
              char ch = input.charAt(i);
              switch(ch) {
                  case '{' :
                  case '(' :
                  case '[' :
                      stk.addFirst(ch);
                      break;
                  case '}' : 
                      fail = (stk.size() == 0 || (stk.removeFirst() != '{'));
                      break;
                  case ']' :
                      fail = (stk.size() == 0 || (stk.removeFirst() != '['));
                      break;
                  case ')' :
                      fail = (stk.size() == 0 || (stk.removeFirst() != '('));
                      break;
                  default :
                      break;
              }
          }
          System.out.println(!fail & (stk.size() == 0));
      }
   }
}
