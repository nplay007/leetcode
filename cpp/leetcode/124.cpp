class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int res = INT_MIN;
        dfs(root, res);
        return res;
    }
    
    int dfs(TreeNode *root, int &res){
        if(!root) return 0;
        int left = max(0, dfs(root->left, res));
        int right = max(0, dfs(root->right, res));
        res = max(res, left + right + root->val);
        return max(left, right) + root->val;
    }
};