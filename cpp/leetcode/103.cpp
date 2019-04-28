class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> res;
        help(root, 0, res);
        return res;
    }
private:
    void help(TreeNode *root, int level, vector<vector<int>> &res){
        if(!root) return;
        if(res.size() < level + 1) res.push_back(vector<int>());
        if(level % 2 == 0) res[level].push_back(root->val);
        else res[level].insert(res[level].begin(), root->val);
        help(root->left, level + 1, res);
        help(root->right, level + 1, res);
    }
};


class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> res;
        queue<TreeNode* > q;
        q.push(root);
        bool flag = true;
        while(!q.empty()){
            int size = q.size();
            vector<int> level;
            for(int i = 0; i < size; ++i){
                TreeNode *node = q.front(); q.pop();
                if(flag) level.push_back(node->val);
                else level.insert(level.begin(), node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            flag = !flag;
            res.push_back(level);
        }
        return res;
    }
};