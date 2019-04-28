class Solution {
public:
    int sumOfLeftLeaves(TreeNode *root) {
        int res = 0;
        help(root, res);
        return res;
    }

    void help(TreeNode *root, int &res) {
        if (!root) {
            return;
        }
        if (root->left && !root->left->left && !root->left->right) {
            res += root->left->val;
        }
        help(root->left, res);
        help(root->right, res);
    }
};