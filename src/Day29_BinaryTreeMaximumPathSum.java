/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class Day29_BinaryTreeMaximumPathSum {

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

    //0ms beats 100%
    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxHalfPath(TreeNode root) {
            if (root == null) return 0;
            int left = Math.max(0, maxHalfPath(root.left));
            int right = Math.max(0, maxHalfPath(root.right));
            max = Math.max(max, root.val + left + right);
            return Math.max(root.val + right, root.val + left);
        }

        public int maxPathSum(TreeNode root) {
            maxHalfPath(root);
            return max;
        }
    }
}
