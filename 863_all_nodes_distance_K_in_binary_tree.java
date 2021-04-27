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
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        find(root, target);
        dfs(root, K, map.get(root));
        return ans;
    }
    
    private int find(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(TreeNode root, int K, int l) {
        if (root == null) {
            return;
        }
        if (map.containsKey(root)) {
            l = map.get(root);
        }
        if (l == K) {
            ans.add(root.val);
        }
        dfs(root.left, K, l + 1);
        dfs(root.right, K, l + 1);
    }
}
