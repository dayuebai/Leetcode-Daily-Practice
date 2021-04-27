/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ans = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        traverse(root);
        return ans;
    }
    
    private int traverse(TreeNode root) {
        if (root == null)
            return 0;
        
        int lDepth = traverse(root.left);
        int rDepth = traverse(root.right);
        int l = 0;
        int r = 0;
        
        if (root.left != null && root.val == root.left.val) 
            l = lDepth + 1;
        if (root.right != null && root.val == root.right.val)
            r = rDepth + 1;
        
        ans = Math.max(ans, l + r);
        
        return Math.max(l, r);
    }
}
