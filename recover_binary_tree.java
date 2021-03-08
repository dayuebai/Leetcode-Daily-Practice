/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Can solve more two swaps, but use more space
// time: O(NlogN), space: O(N)
//
// class Solution {
//     public void recoverTree(TreeNode root) {
//         List<TreeNode> nodes = new ArrayList<>();
//         List<Integer> node_vals = new ArrayList<>();
//         inOrderTraverse(root, nodes, node_vals);
        
//         Collections.sort(node_vals);
        
//         for (int i = 0; i < nodes.size(); i++) {
//             TreeNode tmp = nodes.get(i);
//             tmp.val = node_vals.get(i);
//             nodes.set(i, tmp);
//         }
        
//     }
    
//     private void inOrderTraverse(TreeNode root, List<TreeNode> nodes, List<Integer> node_vals) {
//         if (root == null)
//             return;
        
//         inOrderTraverse(root.left, nodes, node_vals);
        
//         nodes.add(root);
//         node_vals.add(root.val);
        
//         inOrderTraverse(root.right, nodes, node_vals);
//     }
// }

// Use two pointers to find elements that were swapped (In order traversal)
// time: O(N), space: O(h)

class Solution {
    private TreeNode left;
    private TreeNode right;
    private TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        
        int tmp = right.val;
        right.val = left.val;
        left.val = tmp;
    }
    
    private void inOrderTraverse(TreeNode root) {
        if (root == null)
            return;
        
        inOrderTraverse(root.left);
        
        if (pre != null && root.val <= pre.val) {
            if (left == null)
                left = pre;
            right = root;
        }
        
        pre = root;
        
        inOrderTraverse(root.right);
    }
}

// Follow up: to solve this question using constant space, we have to use Morris traversal.
// Time: O(N), space: O(1)
//
// class Solution {
//     public void recoverTree(TreeNode root) {
        
//     }
// }


