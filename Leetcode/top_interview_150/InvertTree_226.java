package top_interview_150;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class InvertTree_226 {

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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
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
