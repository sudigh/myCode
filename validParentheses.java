/** Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty() || s == null) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Stack<Character> stk = new Stack<Character>();
        boolean ret = true;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '}') { // Check for matching parens by popping the character on top of the stack (should be a matching starting paren)
                if (stk.isEmpty()) {
                    return false;
                } else {
                    if (stk.pop() == '{') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            if (ch == ')') {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    if (stk.pop() == '(') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            if (ch == ']') {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    if (stk.pop() == '[') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch); // Push a starting paren/brace/square into stack
            }
        }
        if (!stk.isEmpty()) { // Stack is non-empty if the sequence of parens do not match
            return false;
        }
        return ret;
    }
}
/** Sample testcases :
 * Valid : ((())), "", {([])}, {}, [()]
 * Invalid : {, {[], (]), {00}
 */
