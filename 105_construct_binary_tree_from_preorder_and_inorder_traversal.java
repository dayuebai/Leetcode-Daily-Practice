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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildHelper(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh) {
        
        if (preLow > preHigh || inLow > inHigh) {
            return null;
        }
        
        TreeNode tree = new TreeNode(preorder[preLow]);
        
        int rootIdx = -1;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == preorder[preLow]) {
                rootIdx = i;
                break;
            }
        }
        
        int leftTreeLen = rootIdx - inLow;
        
        tree.left = buildHelper(preorder, inorder, preLow + 1, preLow + leftTreeLen + 1, inLow, rootIdx - 1);
        tree.right = buildHelper(preorder, inorder, preLow + leftTreeLen + 1, preHigh, rootIdx + 1, inHigh);
        
        return tree;
    }
}
