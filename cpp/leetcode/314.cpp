class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> res;
        map<int, vector<int>> hmap;
        queue<pair<int, TreeNode*>> q;
        q.push(make_pair(0, root));
        while(!q.empty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                int level = q.front().first;
                TreeNode * node = q.front().second;
                q.pop();
                hmap[level].push_back(node->val);
                if(node->left) q.push(make_pair(level - 1, node->left));
                if(node->right) q.push(make_pair(level + 1, node->right));
            }
        }
        for(auto it : hmap) res.push_back(it.second);
        return res;
    }
};