class Solution {
public:
    TreeNode *upsideDownBinaryTree(TreeNode *root) {
        if (!root || !root->left) {
            return root;
        }
        TreeNode *left = root->left;
        TreeNode *right = root->right;
        TreeNode *nroot = upsideDownBinaryTree(left);
        left->right = root;
        left->left = right;
        root->left = NULL;
        root->right = NULL;
        return nroot;
    }
};