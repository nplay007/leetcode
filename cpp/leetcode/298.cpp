class Solution {
public:
    int longestConsecutive(TreeNode* root) {
        TreeNode* pre = NULL;
        int res = 0;
        return dfs(root, pre, res);
    }
    
    int dfs(TreeNode* root, TreeNode* pre, int res){
        if(!root) return res;
        res = (pre && pre->val + 1 == root->val)? res + 1 : 1;
        return max(res, max(dfs(root->left, root, res), dfs(root->right, root, res)));
    }
};