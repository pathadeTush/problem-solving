package top_interview_150;

/**
 * https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class SymmetricTree_101 {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode invert = invertTree(root);
        return solve(root, invert);
    }

    private boolean solve(TreeNode root, TreeNode invert) {
        if (root == null && invert == null) {
            return true;
        }
        if(root == null || invert == null) {
            return false;
        }

        if (root.val != invert.val) {
            return false;
        }

        return solve(root.left, invert.left) && solve(root.right, invert.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tree = new TreeNode(root.val);
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        tree.right = left;
        tree.left = right;

        return tree;
    }

}
