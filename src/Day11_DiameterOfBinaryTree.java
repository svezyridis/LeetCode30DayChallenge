/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Day11_DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //beats 100%
    class Solution {
        int max;

        public int getFarthestLeafFromNode(TreeNode node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) return 1;
            int left = getFarthestLeafFromNode(node.left);
            int right = getFarthestLeafFromNode(node.right);
            if (left + right > max)
                max = left + right;
            return 1 + Math.max(right, left);
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            getFarthestLeafFromNode(root);
            return max;
        }
    }
}
