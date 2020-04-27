/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class Day26_LongestCommonSubsequence {
    //beats 63.52% :|
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
            for (int i = 1; i < text1.length(); i++) {
                if (text1.charAt(i) == text2.charAt(0))
                    dp[i][0] = 1;
                else
                    dp[i][0] = dp[i - 1][0];
            }
            for (int i = 1; i < text2.length(); i++) {
                if (text2.charAt(i) == text1.charAt(0))
                    dp[0][i] = 1;
                else
                    dp[0][i] = dp[0][i - 1];
            }
            for (int i = 1; i < text1.length(); i++) {
                for (int j = 1; j < text2.length(); j++) {
                    if (text1.charAt(i) == text2.charAt(j))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[text1.length() - 1][text2.length() - 1];
        }
    }
}
