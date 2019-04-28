class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> stk;
        while(!stk.empty() || root){
            if(root){
                stk.push(root);
                root = root->left;
            } else {
                TreeNode *node = stk.top(); stk.pop();
                k--;
                if(k == 0) return node->val;
                root = node->right;
            }
        }
        return -1;
    }
};


class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int res = 0;
        dfs(root, k, res);
        return res;
    }
    
    void dfs(TreeNode * root, int  &k, int &res){
        if(!root) return;
        dfs(root->left, k, res);
        k --;
        if(k == 0) res = root->val;
        dfs(root->right, k, res);
    }
};