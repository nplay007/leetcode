class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        if(!root) return {};
        vector<string> res;
        help(root, "", res);
        return res;
    }
    
    void help(TreeNode* root, string ans, vector<string> & res){
        if(!root) return;
        if(!root->left && !root->right){
            res.push_back(ans + to_string(root->val));
            return;
        }
        if(root->left) help(root->left, ans + to_string(root->val)+ "->", res);
        if(root->right) help(root->right, ans + to_string(root->val) + "->", res);
    }
};