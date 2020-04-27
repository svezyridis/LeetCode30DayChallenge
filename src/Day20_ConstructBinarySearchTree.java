/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class Day20_ConstructBinarySearchTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //0ms answer
    class Solution {
        public TreeNode put(TreeNode root, int val) {
            if (root == null) {
                TreeNode node = new TreeNode();
                node.val = val;
                return node;
            }
            if (val < root.val) root.left = put(root.left, val);
            if (val > root.val) root.right = put(root.right, val);
            return root;
        }

        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder.length == 0) return null;
            TreeNode root = new TreeNode();
            root.val = preorder[0];
            for (int i = 1; i < preorder.length; i++) {
                put(root, preorder[i]);
            }
            return root;
        }
    }
}
