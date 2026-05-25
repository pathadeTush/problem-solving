package top_interview_150;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxDeptOfTree_104 {

    public static class TreeNode {
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

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lsbDepth = maxDepth(root.left);
        int rsbDepth = maxDepth(root.right);

        return Math.max(lsbDepth, rsbDepth) + 1;
    }

}
