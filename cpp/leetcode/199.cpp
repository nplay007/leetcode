class Solution
{
  public:
    void recursion(TreeNode *root, int level, vector<int> &res)
    {
        if (!root)
            return;
        if (res.size() == level)
            res.push_back(root->val);
        recursion(root->right, level + 1, res);
        recursion(root->left, level + 1, res);
    }

    vector<int> rightSideView(TreeNode *root)
    {
        vector<int> res;
        recursion(root, 0, res);
        return res;
    }
};

class Solution {
public:
    vector<int> rightSideView(TreeNode *root) {
        vector<int> res;
        queue<TreeNode *> q;
        if (!root) {
            return res;
        }
        q.push(root);
        while (!q.empty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode *node = q.front();
                q.pop();
                if (i == level - 1) {
                    res.push_back(node->val);
                }
                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }
            }
        }
        return res;
    }
};