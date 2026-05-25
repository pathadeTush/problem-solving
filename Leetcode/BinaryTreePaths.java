import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /*
    Problem: https://leetcode.com/problems/binary-tree-paths/
     */

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

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            solve(root, "", ans);
            return ans;
        }

        public void solve(TreeNode root, String path, List<String> ans) {
            if (root == null) {
                return;
            }
            String _path = path.isEmpty() ? String.valueOf(root.val) : path + "->" + root.val;
            if (root.left == null && root.right == null) {
                ans.add(_path);
                return;
            }

            solve(root.left, _path, ans);
            solve(root.right, _path, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
//        root.right = new TreeNode(3);

        System.out.println(root.binaryTreePaths(root));
    }

}
