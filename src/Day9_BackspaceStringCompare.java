/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */
public class Day9_BackspaceStringCompare {
    //0ms beats 100%
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1;
            int j = T.length() - 1;
            while (i >= 0 && j >= 0) {
                if (S.charAt(i) != '#' && T.charAt(j) != '#') {
                    if (S.charAt(i) != T.charAt(j)) {
                        return false;
                    } else {
                        i--;
                        j--;
                        continue;
                    }
                }

                if (S.charAt(i) == '#') {
                    int backSlash = 1;
                    i--;
                    while (i >= 0 && backSlash != 0) {
                        if (S.charAt(i) == '#') {
                            backSlash++;
                            i--;
                        } else {
                            backSlash--;
                            i--;
                        }
                    }
                }
                if (T.charAt(j) == '#') {
                    int backSlash = 1;
                    j--;
                    while (j >= 0 && backSlash != 0) {
                        if (T.charAt(j) == '#') {
                            backSlash++;
                            j--;
                        } else {
                            backSlash--;
                            j--;
                        }
                    }
                }
            }
            if (i < 0 && j < 0)
                return true;
            else if (j < 0) {
                if (S.charAt(i) == '#') {
                    int backSlash = 1;
                    i--;
                    while (i >= 0 && (backSlash != 0 || S.charAt(i) == '#')) {
                        if (S.charAt(i) == '#') {
                            backSlash++;
                            i--;
                        } else {
                            backSlash--;
                            i--;
                        }
                    }
                }
                return i < 0;
            } else {
                if (T.charAt(j) == '#') {
                    int backSlash = 1;
                    j--;
                    while (j >= 0 && (backSlash != 0 || T.charAt(j) == '#')) {
                        if (T.charAt(j) == '#') {
                            backSlash++;
                            j--;
                        } else {
                            backSlash--;
                            j--;
                        }
                    }
                }
                return j < 0;
            }
        }
    }
}
