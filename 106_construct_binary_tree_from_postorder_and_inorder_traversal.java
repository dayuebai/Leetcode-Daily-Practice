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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inLow, int inHigh, int postLow, int postHigh) {
        
        if (inLow > inHigh || postLow > postHigh) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postHigh]);
        
        int rootIdx = -1;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }
        
        int leftTreeLen = rootIdx - inLow;
        
        root.left = buildTreeHelper(inorder, postorder, inLow, rootIdx - 1, postLow, postLow + leftTreeLen - 1);
        root.right = buildTreeHelper(inorder, postorder, rootIdx + 1, inHigh, postLow + leftTreeLen, postHigh - 1);
        
        return root;
    }
}
