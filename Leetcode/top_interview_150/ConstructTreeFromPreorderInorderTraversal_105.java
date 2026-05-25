package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ConstructTreeFromPreorderInorderTraversal_105 {

    private int preorderIdx = 0;

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

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = inorder.length;
//        Map<Integer, Integer> positionInInorder = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            positionInInorder.put(inorder[i], i);
//        }
//
//        preorderIdx = 0;
//
//        return solve(preorder, 0, n, positionInInorder);
//    }

//    private TreeNode solve(int[] preorder, int preorderIdx, int[] inorderRange, Map<Integer, Integer> positionInInorder) {
//        int n = preorder.length;
//        if (preorderIdx >= n) {
//            return null;
//        }
//
//        int currEle = preorder[preorderIdx++];
//        int inOrderIdx = positionInInorder.get(currEle);
//        TreeNode currNode = new TreeNode(currEle);
//        if(inOrderIdx < inorderRange[0] || inOrderIdx > inorderRange[1]) {
//            return currNode;
//        }
//
//        currNode.left = solve(preorder, preorderIdx, new int[]{0, inOrderIdx-1}, positionInInorder);
//        currNode.right = solve(preorder, preorderIdx, new int[]{inOrderIdx+1, n-1}, positionInInorder);
//
//        return currNode;
//    }

}
