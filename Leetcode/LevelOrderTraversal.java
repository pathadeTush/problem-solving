/*

problem:

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        int[] a ={1, 2};
        int[] k = Arrays.copyOf(a, 2);

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.remove();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            if (!level.isEmpty()) {
                ans.add(level);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
//        System.out.println(levelOrderTraversal.levelOrder());
    }


}
