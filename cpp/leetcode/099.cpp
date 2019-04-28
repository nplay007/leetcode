class Solution {
public:
    void recoverTree(TreeNode *root) {
        TreeNode *first = NULL, *second = NULL, *ptr = NULL;
        help(root, ptr, first, second);
        swap(first->val, second->val); //swap value
    }

    void help(TreeNode *root, TreeNode *&ptr, TreeNode *&first, TreeNode *&second) {
        if (!root) {
            return;
        }
        help(root->left, ptr, first, second);
        if (!first && ptr && ptr->val >= root->val) {
            first = ptr;
        }
        if (first && ptr && ptr->val >= root->val) {
            second = root;
        }
        ptr = root;
        help(root->right, ptr, first, second);
    }
};