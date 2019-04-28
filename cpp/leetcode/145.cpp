class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if(!root) return {};
        stack<TreeNode*> stk;
        vector<int> res;
        while(root || !stk.empty()){
            while(root){
                res.push_back(root->val);
                stk.push(root);
                root = root->right;
            }
            TreeNode *node = stk.top(); stk.pop();
            root = node->left;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};




class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if(!root) return {};
        stack<TreeNode*> stk;
        vector<int> res;
        TreeNode *pre = NULL;
        while(!stk.empty() || root){
            while(root){
                stk.push(root);
                root = root->left;
            }
            root = stk.top();
            if(root->right && pre != root->right){
                root = root->right;
            } else {
                res.push_back(root->val);
                pre = root;
                stk.pop();
                root = nullptr;
            }
        }
        return res;
    }
};





void postorder(TreeNode* root, vector<int>& res) {
    if (!root) return;
    postorder(root -> left, res);
    postorder(root -> right, res);
    res.push_back(root -> val);
}
vector<int> postorderTraversal(TreeNode* root) {
    vector<int> res;
    postorder(root, res);
    return res;
}
