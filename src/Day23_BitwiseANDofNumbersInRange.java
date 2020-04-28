/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 */
public class Day23_BitwiseANDofNumbersInRange {
    //5ms beats 42.93% :(
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int res = m;
            if (m == 0) return 0;
            if (n / m >= 2) return 0;
            if (m == 2147483647) return m;
            int x = 1;
            int dif = (n - m);

            while (res != 0 && x <= m) {
                if (x <= 1073741823)
                    x *= 2;
                else break;
                if (res % x < x / 2) continue;
                if (dif >= x / 2 || n % x < x / 2) res -= x / 2;
            }
            return res;
        }
    }
}
