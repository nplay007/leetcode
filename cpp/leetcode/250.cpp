class Solution {
public:
    int countUnivalSubtrees(TreeNode* root) {
        int count = 0;
        help(root, count);
        return count;
    }

    bool help(TreeNode* root, int& count) {
        if(!root) return true;
        auto isLeftUnival = help(root->left, count);
        auto isRightUnival = help(root->right, count);
        if(isLeftUnival && isRightUnival
                && ((!root->left) || root->left->val == root->val)
                && ((!root->right) || root->right->val == root->val)
          ) {
            ++count;
            return true;
        }
        return false;
    }
};