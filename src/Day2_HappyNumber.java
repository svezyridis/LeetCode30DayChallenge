import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Return True if n is a happy number, and False if not.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Day2_HappyNumber {
    //1ms beats 84.32%
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> pastNumbers = new HashSet();
            int result = n;
            while (result != 1) {
                int sum = 0;
                while (result != 0) {
                    int digit = result % 10;
                    sum += digit * digit;
                    result /= 10;
                }
                result = sum;
                if (pastNumbers.contains(result))
                    return false;
                else
                    pastNumbers.add(result);
            }
            return true;
        }
    }
}
