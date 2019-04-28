void levelOrder(vector<vector<int>> &ans, TreeNode *node, int level) {
    if (!node) return;
    if (level >= ans.size()) ans.push_back({});
    ans[level].push_back(node->val);
    levelOrder(ans, node->left, level+1);
    levelOrder(ans, node->right, level+1);
}

vector<vector<int>> levelOrderBottom(TreeNode* root) {
    vector<vector<int>> ans;
    levelOrder(ans, root,0);
    reverse(ans.begin(), ans.end());
    return ans;
}




vector<vector<int>> levelOrderBottom(TreeNode* root) {
    vector<vector<int>> ans;
    queue<TreeNode *> q;
    if (root) q.push(root);
    while (!q.empty()) {
        int len = q.size();
        vector<int> level;
        for (int i = 0;i < len;++i) {
            TreeNode *node = q.front();
            level.push_back(node->val);
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
            q.pop();
        }
        ans.push_back(level);
    }
    reverse(ans.begin(), ans.end());
    return ans;
}
