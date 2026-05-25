/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

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

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] ans = new int[]{root.val};

        int maxBranchPathSum = solve(root, ans);
        return ans[0];
    }

    private static int solve(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int maxPathSumLeft = Math.max(solve(root.left, ans), 0);
        int maxPathSumRight = Math.max(solve(root.right, ans), 0);

//        ans[0] = Math.max(ans[0], root.val);

//        if (maxPathSumLeft == Integer.MIN_VALUE && maxPathSumRight == Integer.MIN_VALUE) {
//            ans[0] = Math.max(ans[0], root.val);
//            return root.val;
//        } else if (maxPathSumLeft == Integer.MIN_VALUE) {
//            ans[0] = Math.max(ans[0], maxPathSumRight + root.val);
//            return Math.max(root.val, maxPathSumRight + root.val);
//        } else if (maxPathSumRight == Integer.MIN_VALUE) {
//            ans[0] = Math.max(ans[0], maxPathSumLeft + root.val);
//            return Math.max(root.val, maxPathSumLeft + root.val);
//        }

        ans[0] = Math.max(ans[0], maxPathSumLeft + maxPathSumRight + root.val);
        return root.val + Math.max(maxPathSumLeft, maxPathSumRight);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(BinaryTreeMaximumPathSum.maxPathSum(root));
    }

}
