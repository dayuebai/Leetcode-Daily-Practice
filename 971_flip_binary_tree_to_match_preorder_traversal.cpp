class Solution {
public:
    vector<int> flipMatchVoyage(TreeNode* root, vector<int>& voyage) {
        vector<int> res;
        int i = 0;
        return helper(root, voyage, i, res) ? res : vector<int>{-1};
    }
    bool helper(TreeNode* node, vector<int>& voyage, int& i, vector<int>& res) {
        if (!node) return true;
        if (node->val != voyage[i]) return false;
        i++;
        if (node->left && node->left->val != voyage[i]) {
            res.push_back(node->val);
            return helper(node->right, voyage, i, res) && helper(node->left, voyage, i, res);
        }
        return helper(node->left, voyage, i, res) && helper(node->right, voyage, i, res);
    }
};
