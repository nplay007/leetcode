class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        stack<TreeNode*> stk;
        vector<int> res;
        if(!root) return res;
        stk.push(root);
        while(!stk.empty()) {
            TreeNode* node = stk.top();
            res.push_back(node->val);
            stk.pop();
            if(node->right) stk.push(node->right);
            if(node->left) stk.push(node->left);
        }
        return res;
    }
};


class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        if(!root) return {};
        vector<int> res;
        stack<TreeNode*> stk;
        while(root || !stk.empty()){
            if(root){
                res.push_back(root->val);
                stk.push(root);
                root = root->left;
            } else {
                TreeNode* node = stk.top(); stk.pop();
                root = node->right;
            }
        }
        return res;
    }
};