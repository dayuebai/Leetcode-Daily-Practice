/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;
    
    public int minDiffInBST(TreeNode root) {
        
        inOrderTraverse(root);
        
        return minDiff;
    }
    
    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inOrderTraverse(root.left);
        
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;
        
        inOrderTraverse(root.right);
    }
}
