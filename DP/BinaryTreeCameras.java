import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/binary-tree-cameras/description/
 */
public class BinaryTreeCameras {

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

    private static class DPKey {
        private TreeNode node;
        private Boolean cameraPlacedAtParent;
        private Boolean isParentCovered;

        public DPKey(TreeNode node, Boolean cameraPlacedAtParent, Boolean isParentCovered) {
            this.node = node;
            this.cameraPlacedAtParent = cameraPlacedAtParent;
            this.isParentCovered = isParentCovered;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DPKey that = (DPKey) o;
            return Objects.equals(node, that.node) &&
                    Objects.equals(cameraPlacedAtParent, that.cameraPlacedAtParent) &&
                    Objects.equals(isParentCovered, that.isParentCovered);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, cameraPlacedAtParent, isParentCovered);
        }

    }

    public static int minCameraCover(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Map<DPKey, Integer> dp = new HashMap<>();

        int ans1 = 1 + solve(root, true, true, dp);
        int ans2 = solve(root, false, false, dp);

        return Math.min(ans1, ans2);
    }

    private static int solve(TreeNode root, boolean cameraPlacedAtParent, boolean isParentCovered, Map<DPKey, Integer> dp) {
        if (root == null) {
            return 0;
        }

        DPKey dpKey = new DPKey(root, cameraPlacedAtParent, isParentCovered);
        if(dp.containsKey(dpKey)) {
            return dp.get(dpKey);
        }

        int ans;
        if (cameraPlacedAtParent) {
            int placeAtLeft = 1 + solve(root.left, true, true, dp);
            int notPlaceAtLeft = solve(root.left, false, true, dp);

            int placeAtRight = 1 + solve(root.right, true, true, dp);
            int notPlaceAtRight = solve(root.right, false, true, dp);

            ans = Math.min(placeAtLeft, notPlaceAtLeft) + Math.min(placeAtRight, notPlaceAtRight);
        } else {
            if(isParentCovered) {
                int placeAtLeft = 1 + solve(root.left, true, true, dp);
                int notPlaceAtLeft = solve(root.left, false, false, dp);

                int placeAtRight = 1 + solve(root.right, true, true, dp);
                int notPlaceAtRight = solve(root.right, false, false, dp);

                ans = Math.min(placeAtLeft, notPlaceAtLeft) + Math.min(placeAtRight, notPlaceAtRight);
            } else {
                int placeAtLeft = 1 + solve(root.left, true, true, dp);
                int notPlaceAtLeft = solve(root.left, false, false, dp);

                int placeAtRight = 1 + solve(root.right, true, true, dp);
                int notPlaceAtRight = solve(root.right, false, false, dp);

                int placeAtLeft_notPlaceAtRight = placeAtLeft + notPlaceAtRight;
                int notPlaceAtLeft_placeAtRight = notPlaceAtLeft + placeAtRight;
                int placeAtLeft_placeAtRight = placeAtLeft + placeAtRight;
                ans = Math.min(placeAtLeft_placeAtRight, Math.min(placeAtLeft_notPlaceAtRight, notPlaceAtLeft_placeAtRight));
            }
        }

        dp.put(dpKey, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(0);
        System.out.println(BinaryTreeCameras.minCameraCover(root));
    }

}
