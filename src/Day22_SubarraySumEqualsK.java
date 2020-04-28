import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Day22_SubarraySumEqualsK {
    // 10ms beats 97.49%
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums.length == 0) return 0;
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap();
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                if (temp == k) count++;
                if (map.containsKey(temp - k)) {
                    count += map.get(temp - k);
                }
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else
                    map.put(temp, 1);
            }
            return count;

        }
    }
}
