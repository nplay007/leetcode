class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if(!root) return {};
        vector<int> ans;
        vector<vector<int>> res;
        help(root, sum, ans, res);
        return res;
    }

private:
    void help(TreeNode* root, int target, vector<int> &ans, vector<vector<int>> &res){
        if(!root) return;
        ans.push_back(root->val);
        if(!root->left && !root->right && (root->val == target)){
            res.push_back(ans);
        }
        help(root->left, target - root->val, ans, res);
        help(root->right, target - root->val, ans, res);
        ans.pop_back();
    }
};




class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if(!root) return {};
        vector<vector<int>> res;
        vector<int> ans;
        stack<TreeNode*> stk;
        int target = 0;
        TreeNode* node = root, *pre = NULL;
        while(node || !stk.empty()){
            while(node){
                stk.push(node);
                ans.push_back(node->val);
                target += node->val;
                node = node->left;
            } 
            node = stk.top();
            if(!node->left && !node->right && target == sum){
                res.push_back(ans);
            }
            if(node->right && pre != node->right){
                node = node->right;
            } else {
                stk.pop();
                ans.pop_back();
                pre = node;
                target -= node->val;
                node = NULL;
            }
        }
        return res;
    }
};