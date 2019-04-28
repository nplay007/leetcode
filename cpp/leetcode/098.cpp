class Solution {
public:
    bool isValidBST(TreeNode *root) {
        return help(root, LONG_MIN, LONG_MAX);
    }
    bool help(TreeNode *root, long min, long max) {
        if (!root) {
            return true;
        }
        if (root->val >= max || root->val <= min) {
            return false;
        }
        return help(root->left, min, root->val) && help(root->right, root->val, max);
    }
};

class Solution {
public:
    bool isValidBST(TreeNode *root) {
        TreeNode *pre = NULL;
        return validate(root, pre);
    }

    bool validate(TreeNode *root, TreeNode *&pre) {
        if (!root) {
            return true;
        }
        if (!validate(root->left, pre)) {
            return false;
        }
        if (pre && pre->val >= root->val) {
            return false;
        }
        pre = root;
        return validate(root->right, pre);
    }
};
