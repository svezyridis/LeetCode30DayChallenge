/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */

import java.util.Stack;

public class Day16_ValidParenthesisString {
    //beats 100%
    class Solution {
        public boolean checkValidString(String s) {
            Stack<Integer> asterisks = new Stack();
            Stack<Integer> left = new Stack();
            int asterisk = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '*')
                    asterisks.add(i);
                else if (c == '(')
                    left.add(i);
                else {
                    if (asterisks.isEmpty() && left.isEmpty()) return false;
                    else if (left.isEmpty()) asterisks.pop();
                    else left.pop();
                }
            }
            while (!left.isEmpty()) {
                if (asterisks.isEmpty() || asterisks.pop() < left.pop())
                    return false;
            }

            return true;


        }
    }
}
