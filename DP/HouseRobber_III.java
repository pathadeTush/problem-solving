import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobber_III {

    private static class TreeNode {
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

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Map<TreeNode, Map<Boolean, Integer>> dp = new HashMap<>();
        return Math.max(root.val + solve(root, true, dp), solve(root, false, dp));
    }

    private static int solve(TreeNode root, boolean prevTaken, Map<TreeNode, Map<Boolean, Integer>> dp) {
        if (root == null) {
            return 0;
        }

        if(dp.containsKey(root) && dp.get(root).containsKey(prevTaken)) {
            return dp.get(root).get(prevTaken);
        }

        int ans = 0;
        if (prevTaken) {
            int left = solve(root.left, false, dp);
            int right = solve(root.right, false, dp);
            ans = left + right;
        } else {
            int leftTaken = ((root.left != null) ? root.left.val : 0) + solve(root.left, true, dp);
            int leftNotTaken = solve(root.left, false, dp);
            int rightTaken = ((root.right != null) ? root.right.val : 0) + solve(root.right, true, dp);
            int rightNotTaken = solve(root.right, false, dp);

            ans = Math.max(leftTaken, leftNotTaken) + Math.max(rightTaken, rightNotTaken);
        }

        Map<Boolean, Integer> map = dp.getOrDefault(root, new HashMap<>());
        map.put(prevTaken, ans);
        dp.put(root, map);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);

        System.out.println(HouseRobber_III.rob(root));
    }

}
