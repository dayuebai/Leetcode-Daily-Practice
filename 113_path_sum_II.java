/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// My first solution:
//
// class Solution {
//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         traverse(root, sum, res, path);
//         return res;
//     }
    
//     private void traverse(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
//         if (root == null)
//             return;
//         List<Integer> path_copy = new ArrayList<>();
//         for (int val : path) {
//             path_copy.add(val);
//         }
//         path_copy.add(root.val);
        
//         if (root.left == null && root.right == null && root.val == sum) {
//             res.add(path_copy);   
//         }
        
//         traverse(root.left, sum - root.val, res, path_copy);
//         traverse(root.right, sum - root.val, res, path_copy);
//     }
// }
//
//
// Optimization
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, sum, res, path);
        return res;
    }
    
    private void traverse(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> pathC = List.copyOf(path);
            res.add(pathC);
        }
        
        traverse(root.left, sum - root.val, res, path);
        traverse(root.right, sum - root.val, res, path);
        path.remove(path.size() -1 );
    }
}
