import java.util.Arrays;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * <p>
 * If there're duplicates in arr, count them seperately.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * Example 2:
 * <p>
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * Example 3:
 * <p>
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * Example 4:
 * <p>
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 */
public class Day7_CountingElements {
    //0ms
    class Solution {
        public int countElements(int[] arr) {
            int count = 0;
            int same = 1;
            Arrays.sort(arr);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1] + 1) {
                    count += same;
                }
                if (arr[i] == arr[i - 1])
                    same++;
                else {
                    same = 1;
                }
            }
            return count;

        }
    }
}
