class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> res;
        stack<TreeNode *> stk;
        TreeNode *cur = root;
        while(!stk.empty() || cur) {
            if(cur) {
                stk.push(cur);
                cur = cur->left;
            } else {
                TreeNode *node = stk.top();
                res.push_back(node->val);
                stk.pop();
                cur = node->right;
            }
        }
        return res;
    }
};