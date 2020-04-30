/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 */
public class Day30_CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //0ms
    class Solution {
        public boolean isValid(TreeNode root, int[] arr, int index) {
            if (root == null) return false;
            if (root.val != arr[index]) return false;
            if (index == arr.length - 1) return root.left == null && root.right == null;
            return isValid(root.left, arr, index + 1) || isValid(root.right, arr, index + 1);
        }

        public boolean isValidSequence(TreeNode root, int[] arr) {
            return isValid(root, arr, 0);
        }
    }
}
