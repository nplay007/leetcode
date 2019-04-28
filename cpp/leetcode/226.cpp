class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root) return root;
        invertTree(root->left);
        invertTree(root->right);
        swap(root->left, root->right);
        return root;
    }
};


TreeNode* invertTree(TreeNode* root) {
    if(!root) return root;
    stack<TreeNode*> stk;
    stk.push(root);
    while (!stk.empty()) {
        TreeNode* node = stk.top(); stk.pop();
        if(node->left) stk.push(node->left);
        if(node->right) stk.push(node->right)
        swap(node->left, node->right);
    }
    return root;
}
