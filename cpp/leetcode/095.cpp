class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        if (n == 0) {
            return {};
        }
        return dfs(1, n);
    }

    vector<TreeNode *> dfs(int start, int end) {
        vector<TreeNode *> res;
        if (start > end) {
            res.push_back(NULL);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (auto left : dfs(start, i - 1)) {
                for (auto right : dfs(i + 1, end)) {
                    TreeNode *root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    res.push_back(root);
                }
            }
        }
        return res;
    }
};