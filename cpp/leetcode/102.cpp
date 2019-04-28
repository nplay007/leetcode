class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> res;
        help(root, 0, res);
        return res;
    }
private:
    void help(TreeNode* root, int level, vector<vector<int>> &res){
        if(!root) return;
        if(res.size() < level + 1) res.push_back(vector<int>());
        res[level].push_back(root->val);
        help(root->left, level + 1, res);
        help(root->right, level + 1, res);
    }
};



class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> res;
        queue<TreeNode*> q;
        vector<int> level;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            level.clear();
            for(int i = 0; i < size; ++i){
                TreeNode *node = q.front(); q.pop();
                level.push_back(node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            res.push_back(level);
        }
        return res;
    }
};