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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        if (d == 1) {
            return new TreeNode(v, root, null);
        }
        
        dfs(root, v, 1, d-1);
        
        return root;
        
    }
    
    private void dfs (TreeNode root, int v, int curD, int tarD) {
        if (root == null) {
            return;
        }
        
        if (curD == tarD) {
            root.left = new TreeNode(v, root.left, null);
            root.right = new TreeNode(v, null, root.right);
            return;
        }
        
        dfs(root.left, v, curD+1, tarD);
        dfs(root.right, v, curD+1, tarD);
    }
}
