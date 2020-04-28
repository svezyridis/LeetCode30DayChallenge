/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Day3_MaximumSubarray {
    //1ms beats 67.17%
    class Solution {
        public int max(int[] nums, int lo, int hi) {
            if (lo == hi)
                return nums[lo];
            else {
                int mid = lo + (hi - lo) / 2;
                int leftMax = nums[mid];
                int sum = 0;
                for (int i = mid; i >= lo; i--) {
                    sum += nums[i];
                    if (sum > leftMax)
                        leftMax = sum;
                }
                int rightMax = nums[mid + 1];
                sum = 0;
                for (int i = mid + 1; i <= hi; i++) {
                    sum += nums[i];
                    if (sum > rightMax)
                        rightMax = sum;
                }
                if (rightMax > 0 && leftMax > 0)
                    return Math.max(rightMax + leftMax, Math.max(max(nums, lo, mid), max(nums, mid + 1, hi)));
                else return Math.max(max(nums, lo, mid), max(nums, mid + 1, hi));
            }
        }

        public int maxSubArray(int[] nums) {
            int lo = 0;
            int hi = nums.length - 1;
            return max(nums, lo, hi);
        }
    }
}
