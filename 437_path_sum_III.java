/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time: O(N^2), Space: O(N)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return numberOfPaths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int numberOfPaths(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (root.val == sum ? 1 : 0) + numberOfPaths(root.left, sum - root.val) + numberOfPaths(root.right, sum - root.val);
    }
    
}
